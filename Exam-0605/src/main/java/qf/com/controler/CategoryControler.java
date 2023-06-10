package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Carrier;
import qf.com.entity.Category;
import qf.com.service.CarrierService;
import qf.com.service.CategoryService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 9:29
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class CategoryControler {
    @Resource
    private CategoryService categoryService;
    @RequestMapping(value = "/addCategory")
    public Result addCategory(@RequestBody Category category) {
        category.setUpdateTime(new Date());
        categoryService.addCategory(category);
        return new Result();
    }

    @RequestMapping(value = "/deleteCategory")
    public Result deleteCategory(Integer categoryId) {
        categoryService.deleteCategory(categoryId);
        return new Result();
    }

    @RequestMapping(value = "/updateCategory")
    public Result updateCategory(@RequestBody Category category) {
        category.setUpdateTime(new Date());
        categoryService.updateCategory(category);
        return new Result();
    }

    @RequestMapping(value = "/getCategoryOne")
    public Result getCategoryOne(Integer categoryId) {
        Category categoryOne = categoryService.getCategoryOne(categoryId);
        return new Result(categoryOne);
    }
    @RequestMapping(value = "/getCategoryList")
    public Result getCategoryList(Integer pageNo,Integer pageSize) {
        Page categoryList = categoryService.getCategoryList(pageNo, pageSize);
        return new Result(categoryList);
    }
    @RequestMapping(value = "/getListCategory")
    public Result getListCategory() {
        List<Category> listCategory = categoryService.getListCategory();
        return new Result(listCategory);
    }
}
