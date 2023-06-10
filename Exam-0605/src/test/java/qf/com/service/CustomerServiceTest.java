package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 16:01
 * @version：1.0
 */
public class CustomerServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    CustomerService customerService = ioc.getBean(CustomerService.class);
    @Test
    public void addCustomer() {
    }

    @Test
    public void deleteCustomer() {
    }

    @Test
    public void updateCustomer() {
    }

    @Test
    public void getCustomerOne() {
    }

    @Test
    public void getCustomerList() {

    }
}
