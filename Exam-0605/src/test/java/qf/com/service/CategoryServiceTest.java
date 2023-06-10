package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Category;
import qf.com.mapper.CategoryMapper;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 23:54
 * @version：1.0
 */
public class CategoryServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    CategoryMapper categoryMapper = ioc.getBean(CategoryMapper.class);
    @Test
    public void addCategory() {

    }

    @Test
    public void deleteCategory() {
    }

    @Test
    public void updateCategory() {
    }

    @Test
    public void getCategoryOne() {
    }

    @Test
    public void getCategoryList() {
        List<Category> categoryList = categoryMapper.getCategoryList();
        for (Category category : categoryList) {
            System.out.println(category);
        }

    }
}
