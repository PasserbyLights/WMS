package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.User;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 18:36
 * @version：1.0
 */
public class UserMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserMapper userMapper = ioc.getBean(UserMapper.class);
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
        User userOne = userMapper.getUserOne(1);
        System.out.println(userOne);
    }

    @Test
    public void getUserList() {
    }
}
