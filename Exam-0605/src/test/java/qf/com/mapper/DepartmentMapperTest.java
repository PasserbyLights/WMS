package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.Department;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 12:28
 * @version：1.0
 */
public class DepartmentMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    DepartmentMapper departmentMapper = ioc.getBean(DepartmentMapper.class);
    @Test
    public void addDepartment() {
    }

    @Test
    public void deleteDepartment() {
    }

    @Test
    public void updateDepartment() {
    }

    @Test
    public void getDepartmentOne() {
        Department departmentOne = departmentMapper.getDepartmentOne(1);
        System.out.println(departmentOne);
    }

    @Test
    public void getDepartmentList() {
        List<Department> departmentList = departmentMapper.getDepartmentList();
        for (Department department : departmentList) {
            System.out.println(department);
        }
    }
}
