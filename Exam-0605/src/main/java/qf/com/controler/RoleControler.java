package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Product;
import qf.com.entity.Role;
import qf.com.service.RoleService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 9:25
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class RoleControler {
    @Resource
    private RoleService roleService;
    @RequestMapping(value = "/addRole")
    public Result addRole(@RequestBody Role role) {
        System.out.println("role:"+role);
        role.setUpdateTime(new Date());
        roleService.addRole(role);
        return new Result();
    }

    @RequestMapping(value = "/deleteRole")
    public Result deleteRole(Integer roleId) {
        roleService.deleteRole(roleId);
        return new Result();
    }

    @RequestMapping(value = "/updateRole")
    public Result updateRole(@RequestBody Role role) {
        role.setUpdateTime(new Date());
        roleService.updateRole(role);
        return new Result();
    }

    @RequestMapping(value = "/getRoleOne")
    public Result getRoleOne(Integer roleId) {
        Role role = roleService.getRoleOne(roleId);
        return new Result(role);
    }
    @RequestMapping(value = "/getRoleList")
    public Result getRoleList(Integer pageNo,Integer pageSize) {
        Page page = roleService.getRoleList(pageNo, pageSize);
        return new Result(page);
    }
    @RequestMapping(value = "/getListRole")
    public Result getListRole() {
        List<Role> listRole = roleService.getListRole();
        return new Result(listRole);
    }
}
