package qf.com.controler;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Carrier;
import qf.com.entity.Customer;
import qf.com.service.CustomerService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 16:27
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class CustomerControler {
    @Resource
    private CustomerService customerService;

    @RequestMapping(value = "/addCustomer")
    public Result addCustomer(@RequestBody Customer customer) {
        customer.setUpdateTime(new Date());
        customerService.addCustomer(customer);
        return new Result();
    }

    @RequestMapping(value = "/deleteCustomer")
    public Result deleteCustomer(Integer customerId) {
        customerService.deleteCustomer(customerId);
        return new Result();
    }

    @RequestMapping(value = "/updateCustomer")
    public Result updateCustomer(@RequestBody Customer customer) {
        customer.setUpdateTime(new Date());
        customerService.updateCustomer(customer);
        return new Result();
    }

    @RequestMapping(value = "/getCustomerOne")
    public Result getCustomerOne(Integer customerId) {
        Customer customer = customerService.getCustomerOne(customerId);
        return new Result(customer);
    }
    @RequestMapping(value = "/getCustomerOne1")
    public Result getCustomerOne1(String customerName) {
        List<Customer> customer = customerService.getCustomerOne1(customerName);
        return new Result(customer);
    }
    @RequestMapping(value = "/getCustomerList")
    public Result getCustomerList(Integer pageNo, Integer pageSize,
                                  String customerName, String customerTel,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date startTime,
                                  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date endTime) {
        System.out.println("customerName:"+customerName);
        System.out.println("customerTel:"+customerTel);
        System.out.println("startTime:"+startTime);
        System.out.println("endTime:"+endTime);
        Page customerList = customerService.getCustomerList(pageNo,pageSize,customerName,customerTel,startTime,endTime);
        return new Result(customerList);
    }
}
