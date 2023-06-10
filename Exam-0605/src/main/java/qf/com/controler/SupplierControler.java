package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Supplier;
import qf.com.service.IndustryService;
import qf.com.service.SupplierService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 18:24
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class SupplierControler {
    @Resource
    private SupplierService supplierService;

    @RequestMapping(value = "/addSupplier")
    public Result addSupplier(@RequestBody Supplier supplier) {
        supplier.setUpdateTime(new Date());
        supplierService.addSupplier(supplier);
        return new Result();
    }

    @RequestMapping(value = "/deleteSupplier")
    public Result deleteSupplier(Integer supplierId) {
        supplierService.deleteSupplier(supplierId);
        return new Result();
    }

    @RequestMapping(value = "/updateSupplier")
    public Result updateSupplier(@RequestBody Supplier supplier) {
        supplier.setUpdateTime(new Date());
        supplierService.updateSupplier(supplier);
        return new Result();
    }

    @RequestMapping(value = "/getSupplierOne")
    public Result getSupplierOne(Integer supplierId) {
        Supplier supplierOne = supplierService.getSupplierOne(supplierId);
        return new Result(supplierOne);
    }
    @RequestMapping(value = "/getSupplierOne1")
    public Result getSupplierOne1(String supplierName) {
        System.out.println("supplierName:"+supplierName);
        List<Supplier> supplierOne = supplierService.getSupplierOne1(supplierName);
        return new Result(supplierOne);
    }
    @RequestMapping(value = "/getSupplierList")
    public Result getSupplierList(Integer pageNo,Integer pageSize) {
        Page supplierList = supplierService.getSupplierList(pageNo, pageSize);
        return new Result(supplierList);
    }
}
