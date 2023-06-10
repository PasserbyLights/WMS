package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Menus;
import qf.com.entity.Product;
import qf.com.entity.Repository;
import qf.com.service.ProductService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 19:21
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class ProductControler {
    @Resource
    private ProductService productService;
    @RequestMapping(value = "/addProduct")
    public Result addProduct(@RequestBody Product product) {
        product.setUpdateTime(new Date());
        System.out.println(product);
        productService.addProduct(product);
        return new Result();
    }

    @RequestMapping(value = "/deleteProduct")
    public Result deleteProduct(Integer productId) {
        productService.deleteProduct(productId);
        return new Result();
    }

    @RequestMapping(value = "/updateProduct")
    public Result updateProduct(@RequestBody Product product) {
        product.setUpdateTime(new Date());
        System.out.println(product);
        productService.updateProduct(product);
        return new Result();
    }

    @RequestMapping(value = "/getProductOne")
    public Result getProductOne(Integer productId) {
        Product productOne = productService.getProductOne(productId);
        return new Result(productOne);
    }
    @RequestMapping(value = "/getProductOne1")
    public Result getProductOne1(String productName) {
        List<Product> productOne = productService.getProductOne1(productName);
        return new Result(productOne);
    }
    @RequestMapping(value = "/getProductList")
    public Result getProductList(Integer pageNo,Integer pageSize) {
        Page page = productService.getProductList(pageNo, pageSize);
        return new Result(page);
    }
    @RequestMapping(value = "/getListProduct")
    public Result getListProduct() {
        List<Product> productList = productService.getProductList();
        return new Result(productList);
    }
}
