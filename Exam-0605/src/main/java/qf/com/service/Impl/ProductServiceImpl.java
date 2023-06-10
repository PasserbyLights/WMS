package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import qf.com.dto.Page;
import qf.com.entity.Product;
import qf.com.entity.Source;
import qf.com.mapper.ProductMapper;
import qf.com.service.ProductService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 19:05
 * @version：1.0
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductMapper productMapper;

    @Override
    public void addProduct(Product product) {
        productMapper.addProduct(product);
    }

    @Override
    public void deleteProduct(Integer productId) {
        productMapper.deleteProduct(productId);
    }

    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
    }

    @Override
    public Product getProductOne(Integer productId) {
        return productMapper.getProductOne(productId);
    }

    @Override
    public List<Product> getProductOne1(String productName) {
        return productMapper.getProductOne1(productName);
    }

    @Override
    public Page getProductList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Product> products = productMapper.getProductList();

        PageInfo info = new PageInfo(products);
        Page page = new Page();
        page.setPageNo(info.getPageNum());//当前页
        page.setPageSize(info.getPageSize());//页容量
        page.setPageCount(info.getPages());//总页数
        page.setTotal(info.getTotal());//总记录数
        page.setData(info.getList());//当前页
        page.setHasPre(info.isHasPreviousPage());//是否有上一页
        page.setHasNext(info.isHasNextPage());//是否有下一页
        return page;
    }

    @Override
    public List<Product> getProductList() {
        return productMapper.getProductList();
    }
}
