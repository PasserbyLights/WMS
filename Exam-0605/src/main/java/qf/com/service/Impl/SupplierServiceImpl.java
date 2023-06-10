package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Industry;
import qf.com.entity.Supplier;
import qf.com.mapper.SupplierMapper;
import qf.com.service.SupplierService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 17:58
 * @version：1.0
 */
@Transactional
@Service
public class SupplierServiceImpl implements SupplierService {
    @Resource
    private SupplierMapper supplierMapper;

    @Override
    public void addSupplier(Supplier supplier) {
        supplierMapper.addSupplier(supplier);
    }

    @Override
    public void deleteSupplier(Integer supplierId) {
        supplierMapper.deleteSupplier(supplierId);
    }

    @Override
    public void updateSupplier(Supplier supplier) {
        supplierMapper.updateSupplier(supplier);
    }

    @Override
    public Supplier getSupplierOne(Integer supplierId) {
        return supplierMapper.getSupplierOne(supplierId);
    }

    @Override
    public List<Supplier> getSupplierOne1(String supplierName) {
        return supplierMapper.getSupplierOne1(supplierName);
    }

    @Override
    public Page getSupplierList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Supplier> suppliers = supplierMapper.getSupplierList();

        PageInfo info = new PageInfo(suppliers);
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
}
