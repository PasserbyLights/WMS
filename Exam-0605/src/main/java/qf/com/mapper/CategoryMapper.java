package qf.com.mapper;

import qf.com.entity.Category;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 23:28
 * @version：1.0
 */
public interface CategoryMapper {
    void addCategory(Category category);

    void deleteCategory(Integer categoryId);

    void updateCategory(Category category);

    Category getCategoryOne(Integer categoryId);

    List<Category> getCategoryList();

}
