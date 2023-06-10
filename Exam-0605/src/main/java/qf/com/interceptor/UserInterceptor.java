package qf.com.interceptor;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import qf.com.entity.User;
import qf.com.mapper.UserMapper;
import qf.com.utils.JwtUtils;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@CrossOrigin
@ResponseBody
@Controller
public class UserInterceptor implements HandlerInterceptor {

    @Resource
    private UserMapper userMapper;

    /**
     * 在请求控制器方法执行前被调用
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 判断当前请求是否已经登录过,如果已经登陆过,那就放行,否则不放
         */
        //String token = request.getHeader("token");
        String token = request.getParameter("token");
        System.out.println("--->>>>" + token);
        if (token == null || token == "") {
            throw new Exception("未登录...");
        } else {
            String userEmail = JwtUtils.getClaim(token, "iss");
            User user = userMapper.getUserByEmail(userEmail);
            System.out.println(user);
            if (user == null) {
                throw new Exception("token失效...");
            } else {
                return true;
            }
        }
        //return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
