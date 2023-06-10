package qf.com.controler;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.dto.loginDto;
import qf.com.entity.User;
import qf.com.entity.User;
import qf.com.mapper.UserMapper;
import qf.com.service.UserService;
import qf.com.utils.JwtUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;
import java.util.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 13:57
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class UserControler {
    @Resource
    private UserService userService;
    @Resource
    private UserMapper userMapper;

    @RequestMapping(value = "/addUser")
    public Result addUser(@RequestBody User user) {
        user.setUpdateTime(new Date());
        userService.addUser(user);
        return new Result();
    }

    @RequestMapping(value = "/deleteUser")
    public Result deleteUser(Integer userId) {
        System.out.println("删除userId：" + userId);
        userService.deleteUser(userId);
        return new Result();
    }

    @RequestMapping(value = "/updateUser")
    public Result updateUser(@RequestBody User user) {
        user.setUpdateTime(new Date());
        userService.updateUser(user);
        return new Result();
    }

    @RequestMapping(value = "/getUserOne")
    public Result getUserOne(Integer userId) {
        System.out.println(userId);
        User userOne = userService.getUserOne(userId);
        return new Result(userOne);
    }

    @RequestMapping(value = "/getUserOne1")
    public Result getUserOne1(Integer userId) {
        System.out.println(userId);
        User userOne = userService.getUserOne1(userId);
        return new Result(userOne);
    }

    @RequestMapping(value = "/getUserList")
    public Result getUserList(Integer pageNo, Integer pageSize,
                              String userName, String userTel,
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                              @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        Page userList = userService.getUserList(pageNo, pageSize, userName, userTel, startTime, endTime);
        return new Result(userList);
    }

    //前端登陆接口
    @RequestMapping(value = "/login")
    public Result login(String userEmail, String password) {
        System.out.println("有登陆请求过来……");
        System.out.println("userEmail:" + userEmail);
        System.out.println("password:" + password);
        Map<String, Object> map = new HashMap<>();
        User admin = userService.getAdmin(userEmail, password);
        System.out.println("数据库查询结果:" + admin);
        if (admin == null) {
            map.put("code", 30000);
            map.put("msg", "登陆失败");
            return new Result(30000, "登陆失败");
        } else {
            String token = JwtUtils.sign(userEmail, password);
            //map.put("userEmail", userEmail);
            map.put("token", token);

            Result result = new Result();
            result.setCode(20000);
            result.setMsg("登陆成功");
            result.setData(map);
            System.out.println(result);
            return result;
        }
    }
    //请求查询登陆状态
    @RequestMapping(value = "/getLogin")
    public Result getLogin(HttpServletRequest request) {
        String token = request.getParameter("token");
        System.out.println("--->>>>" + token);
        if (token == null || token.equals("")) {
            Result result = new Result();
            result.setCode(40000);
            result.setMsg("登陆失败，token失效");
            System.out.println(result);
            return result;
        } else {
            String userEmail = JwtUtils.getClaim(token, "iss");
            User user = userMapper.getUserByEmail(userEmail);
            System.out.println(user);
            if (user == null) {
                Result result = new Result();
                result.setCode(50000);
                result.setMsg("登陆失败，token错误");
                System.out.println(result);
                return result;
            } else {
                loginDto loginDto = new loginDto();
                loginDto.setName(user.getUserName());//姓名
                loginDto.setAvatar(user.getAvatar());//头像
                loginDto.setIntroduction("个性签名");//签名
                List<String> roles = new ArrayList();
                roles.add("admin");//角色
                loginDto.setRoles(roles);
                return new Result(20000, "登录成功", loginDto);
            }
        }
    }
}
