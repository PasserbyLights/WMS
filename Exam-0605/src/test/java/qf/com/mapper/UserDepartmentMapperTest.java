package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.UserDepartment;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 12:45
 * @version：1.0
 */
public class UserDepartmentMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    UserDepartmentMapper userDepartmentMapper = ioc.getBean(UserDepartmentMapper.class);
    @Test
    public void addUserDepartment() {
    }

    @Test
    public void deleteUserDepartment() {
    }

    @Test
    public void getUserDepartmentOne() {
    }

    @Test
    public void getUserDepartmentList() {
        List<UserDepartment> userDepartmentList = userDepartmentMapper.getUserDepartmentList();
        for (UserDepartment userDepartment : userDepartmentList) {
            System.out.println(userDepartment);
        }
    }
}
