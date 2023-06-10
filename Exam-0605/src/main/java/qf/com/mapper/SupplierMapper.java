package qf.com.mapper;

import qf.com.entity.Supplier;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 17:32
 * @version：1.0
 */
public interface SupplierMapper {
    //增加
    void addSupplier(Supplier supplier);
    //删除
    void deleteSupplier(Integer supplierId);
    //更新
    void updateSupplier(Supplier supplier);
    //查询单个
    Supplier getSupplierOne(Integer supplierId);
    //查询多个
    List<Supplier> getSupplierList();

    List<Supplier> getSupplierOne1(String  supplierName);
}
