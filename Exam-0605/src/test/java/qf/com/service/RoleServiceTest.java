package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 9:37
 * @version：1.0
 */
public class RoleServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    RoleService productService = ioc.getBean(RoleService.class);
    @Test
    public void addRole() {
    }

    @Test
    public void deleteRole() {
    }

    @Test
    public void updateRole() {
    }

    @Test
    public void getRoleOne() {
    }

    @Test
    public void getListRole() {
    }

    @Test
    public void getRoleList() {
        Page roleList = productService.getRoleList(1, 10);
        System.out.println(roleList);
    }
}
