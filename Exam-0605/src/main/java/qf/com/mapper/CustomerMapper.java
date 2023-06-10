package qf.com.mapper;

import org.apache.ibatis.annotations.Param;
import qf.com.entity.Customer;

import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 15:42
 * @version：1.0
 */
public interface CustomerMapper {

    void addCustomer(Customer customer);

    void deleteCustomer(Integer customerId);

    void updateCustomer(Customer customer);

    Customer getCustomerOne(Integer customerId);
    List<Customer> getCustomerOne1(String customerName);

    //模糊多关系查询
    List<Customer> getCustomerList(@Param("customerName") String customerName,
                                   @Param("customerTel") String customerTel,
                                   @Param("startTime") Date startTime,
                                   @Param("endTime") Date endTime);
}
