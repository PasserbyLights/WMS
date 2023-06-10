package qf.com.controler;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Product;
import qf.com.entity.RecordStock;
import qf.com.service.RecordStockService;
import qf.com.service.RepositoryService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/8 10:06
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class RecordStockControler {
    @Resource
    private RecordStockService recordStockService;

    @RequestMapping(value = "/addRecordStock")
    public Result addRecordStock(@RequestBody RecordStock recordStock) {
        recordStock.setUpdateTime(new Date());
        System.out.println(recordStock);
        recordStockService.addRecordStock(recordStock);
        return new Result();
    }

    @RequestMapping(value = "/updateRecordStock")
    public Result updateRecordStock(@RequestBody RecordStock recordStock) {
        recordStock.setUpdateTime(new Date());
        System.out.println(recordStock);
        recordStockService.updateRecordStock(recordStock);
        return new Result();
    }

    @RequestMapping(value = "/getRecordStockList")
    public Result getRecordStockList(Integer pageNo, Integer pageSize, Integer repoId, Integer productId) {
        System.out.println("Integer pageNo:"+pageNo);
        System.out.println("Integer pageSize:"+pageSize);
        System.out.println("Integer repoId:"+repoId);
        System.out.println("Integer productId:"+productId);
        Page recordStockList = recordStockService.getRecordStockList(pageNo, pageSize, repoId, productId);
        return new Result(recordStockList);
    }

    @RequestMapping(value = "/getListStockRecord")
    public Result getListStockRecord(Integer repoId, Integer productId) {
        System.out.println(productId);
        System.out.println(repoId);
        RecordStock recordStockList = recordStockService.getListStockRecord(repoId, productId);
        return new Result(recordStockList);
    }

    @RequestMapping(value = "/getRecordStockOne")
    public Result getRecordStockOne(Integer productId) {
        List<RecordStock> recordStockOne = recordStockService.getRecordStockOne(productId);
        return new Result(recordStockOne);
    }

    @RequestMapping(value = "/getRecordStockOne1")
    public Result getRecordStockOne1( Integer productId,Integer repoId) {
        RecordStock recordStockOne = recordStockService.getRecordStockOne1(productId,repoId);
        return new Result(recordStockOne);
    }
}
