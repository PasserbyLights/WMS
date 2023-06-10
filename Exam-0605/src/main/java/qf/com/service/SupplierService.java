package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Supplier;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 17:36
 * @version：1.0
 */
public interface SupplierService {
    //增加
    void addSupplier(Supplier supplier);

    //删除
    void deleteSupplier(Integer supplierId);

    //更新
    void updateSupplier(Supplier supplier);

    //查询单个
    Supplier getSupplierOne(Integer supplierId);

    List<Supplier> getSupplierOne1(String supplierName);

    //查询多个
    Page getSupplierList(Integer pageNo, Integer pageSize);
}
