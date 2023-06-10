package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.service.MenusService;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 14:22
 * @version：1.0
 */
public class MenusMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    MenusService menusService = ioc.getBean(MenusService.class);
    @Test
    public void addMenus() {
    }

    @Test
    public void deleteMenus() {
    }

    @Test
    public void updateMenus() {
    }

    @Test
    public void getMenusOne() {
    }

    @Test
    public void getMenusList() {
        Page menusList = menusService.getMenusList(1, 5);
        System.out.println(menusList);
    }
}
