package qf.com.mapper;

import qf.com.entity.Product;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 19:02
 * @version：1.0
 */
public interface ProductMapper {
    void addProduct(Product product);

    void deleteProduct(Integer productId);

    void updateProduct(Product product);

    Product getProductOne(Integer productId);
    List<Product> getProductOne1(String productName);

    List<Product> getProductList();
}
