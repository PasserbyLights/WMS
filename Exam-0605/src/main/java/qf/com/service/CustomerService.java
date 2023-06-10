package qf.com.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Customer;
import qf.com.mapper.CategoryMapper;

import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 15:44
 * @version：1.0
 */
public interface CustomerService {

    void addCustomer(Customer customer);

    void deleteCustomer(Integer customerId);

    void updateCustomer(Customer customer);

    Customer getCustomerOne(Integer customerId);

    List<Customer> getCustomerOne1(String customerName);

    Page getCustomerList(Integer pageNo, Integer pageSize,
                         String customerName, String customerTel,
                         Date startTime, Date endTime);
}
