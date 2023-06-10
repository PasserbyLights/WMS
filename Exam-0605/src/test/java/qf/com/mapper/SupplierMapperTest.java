package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.Supplier;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 17:45
 * @version：1.0
 */
public class SupplierMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    SupplierMapper supplierMapper = ioc.getBean(SupplierMapper.class);
    @Test
    public void addSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierName("湖南重工");
        supplier.setSupplierLeader("湖南重工");
        supplier.setSupplierTel("11111111111");
        supplier.setSupplierEmail("1@163.com");
        supplier.setSupplierAddress("湖南……");
        supplier.setCreateTime(new Date());
        supplier.setUpdateTime(new Date());
        supplier.setIsDelete(1);
        for (int i = 0; i < 20; i++) {
            supplierMapper.addSupplier(supplier);
        }
    }

    @Test
    public void deleteSupplier() {
        supplierMapper.deleteSupplier(3);
    }

    @Test
    public void updateSupplier() {
        Supplier supplier = new Supplier();
        supplier.setSupplierName("湖南重工");
        supplier.setSupplierLeader("小王");
        supplier.setSupplierTel("11111111111");
        supplier.setSupplierEmail("1@163.com");
        supplier.setSupplierAddress("湖南……");
        supplier.setCreateTime(new Date());
        supplier.setUpdateTime(new Date());
        supplier.setIsDelete(1);
        supplier.setSupplierId(3);
        supplierMapper.updateSupplier(supplier);
    }

    @Test
    public void getSupplierOne() {
        Supplier supplierOne = supplierMapper.getSupplierOne(3);
        System.out.println(supplierOne);
    }

    @Test
    public void getSupplierList() {
        List<Supplier> supplierList = supplierMapper.getSupplierList();
        for (Supplier supplier : supplierList) {
            System.out.println(supplier);
        }
    }
}
