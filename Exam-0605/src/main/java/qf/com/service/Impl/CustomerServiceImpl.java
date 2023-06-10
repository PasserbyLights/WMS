package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Category;
import qf.com.entity.Customer;
import qf.com.mapper.CustomerMapper;
import qf.com.service.CustomerService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 15:45
 * @version：1.0
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Resource
    private CustomerMapper customerMapper;

    @Override
    public void addCustomer(Customer customer) {
        customerMapper.addCustomer(customer);
    }

    @Override
    public void deleteCustomer(Integer customerId) {
        customerMapper.deleteCustomer(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerMapper.updateCustomer(customer);
    }

    @Override
    public Customer getCustomerOne(Integer customerId) {
        return customerMapper.getCustomerOne(customerId);
    }

    public List<Customer> getCustomerOne1(String customerName) {
        return customerMapper.getCustomerOne1(customerName);
    }

    @Override
    public Page getCustomerList(Integer pageNo, Integer pageSize, String customerName, String customerTel, Date startTime, Date endTime) {
        PageHelper.startPage(pageNo, pageSize);
        List<Customer> customerList = customerMapper.getCustomerList(customerName, customerTel, startTime, endTime);

        PageInfo info = new PageInfo(customerList);
        Page page = new Page();
        page.setPageNo(info.getPageNum());//当前页
        page.setPageSize(info.getPageSize());//页容量
        page.setPageCount(info.getPages());//总页数
        page.setTotal(info.getTotal());//总记录数
        page.setData(info.getList());//当前页
        page.setHasPre(info.isHasPreviousPage());//是否有上一页
        page.setHasNext(info.isHasNextPage());//是否有下一页
        return page;
    }

}
