package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Product;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 19:04
 * @version：1.0
 */
public interface ProductService {
    void addProduct(Product product);

    void deleteProduct(Integer productId);

    void updateProduct(Product product);

    Product getProductOne(Integer productId);
    List<Product> getProductOne1(String productName);

    Page getProductList(Integer pageNo, Integer pageSize);

    List<Product> getProductList();
}
