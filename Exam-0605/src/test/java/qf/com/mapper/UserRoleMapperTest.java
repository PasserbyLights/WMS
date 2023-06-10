package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.UserRole;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 12:23
 * @version：1.0
 */
public class UserRoleMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserRoleMapper userRoleMapper = ioc.getBean(UserRoleMapper.class);
    @Test
    public void addUserRole() {
    }

    @Test
    public void deleteUserRole() {
    }

    @Test
    public void getUserRoleOne() {
        UserRole userRoleOne = userRoleMapper.getUserRoleOne(1);
        System.out.println(userRoleOne);
    }

    @Test
    public void getUserRoleList() {
        List<UserRole> userRoleList = userRoleMapper.getUserRoleList();
        for (UserRole userRole : userRoleList) {
            System.out.println(userRole);
        }
    }
}
