package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 19:18
 * @version：1.0
 */
public class ProductServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    ProductService productService = ioc.getBean(ProductService.class);
    @Test
    public void addProduct() {
    }

    @Test
    public void deleteProduct() {
    }

    @Test
    public void updateProduct() {
    }

    @Test
    public void getProductOne() {
    }

    @Test
    public void getProductList() {
        Page productList = productService.getProductList(1, 5);
        System.out.println(productList);
    }
}
