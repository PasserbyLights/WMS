package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Supplier;
import qf.com.mapper.SupplierMapper;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 18:21
 * @version：1.0
 */
public class SupplierServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    SupplierService supplierService = ioc.getBean(SupplierService.class);
    @Test
    public void addSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierName("湖南重工3");
        supplier.setSupplierLeader("湖南重工3");
        supplier.setSupplierTel("11111111111");
        supplier.setSupplierEmail("1@163.com");
        supplier.setSupplierAddress("湖南……");
        supplier.setCreateTime(new Date());
        supplier.setUpdateTime(new Date());
        supplier.setIsDelete(1);
        supplierService.addSupplier(supplier);
    }

    @Test
    public void deleteSupplier() {
        supplierService.deleteSupplier(5);
    }

    @Test
    public void updateSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierName("湖南重工3");
        supplier.setSupplierLeader("湖南重工3");
        supplier.setSupplierTel("11111111111");
        supplier.setSupplierEmail("1@163.com");
        supplier.setSupplierAddress("湖南……");
        supplier.setCreateTime(new Date());
        supplier.setUpdateTime(new Date());
        supplier.setIsDelete(1);
        supplier.setSupplierId(5);
        supplierService.updateSupplier(supplier);
    }

    @Test
    public void getSupplierOne() {
        Supplier supplierOne = supplierService.getSupplierOne(5);
        System.out.println(supplierOne);
    }

    @Test
    public void getSupplierList() {
        Page supplierList = supplierService.getSupplierList(1, 10);
        System.out.println(supplierList);
    }
}
