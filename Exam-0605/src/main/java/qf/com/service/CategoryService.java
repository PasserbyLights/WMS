package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Category;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 23:30
 * @version：1.0
 */
public interface CategoryService {
    void addCategory(Category category);

    void deleteCategory(Integer categoryId);

    void updateCategory(Category category);

    Category getCategoryOne(Integer categoryId);

    Page getCategoryList(Integer pageNo, Integer pageSize);

    List<Category> getListCategory();

}
