package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 14:03
 * @version：1.0
 */
public class UserServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserService userService = ioc.getBean(UserService.class);
    @Test
    public void addUser() {
    }

    @Test
    public void deleteUser() {
    }

    @Test
    public void updateUser() {
    }

    @Test
    public void getUserOne() {
    }

    @Test
    public void getUserList() {
/*        Page userList = userService.getUserList(1, 5);
        System.out.println(userList);*/
    }
}
