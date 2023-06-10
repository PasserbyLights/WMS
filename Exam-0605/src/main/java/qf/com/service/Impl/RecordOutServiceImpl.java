package qf.com.service.Impl;

import org.springframework.stereotype.Service;
import qf.com.entity.RecordOut;
import qf.com.entity.RecordStock;
import qf.com.mapper.RecordOutMapper;
import qf.com.mapper.RecordStockMapper;
import qf.com.service.RecordOutService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/9 9:28
 * @version：1.0
 */
@Service
public class RecordOutServiceImpl implements RecordOutService {
    @Resource
    private RecordOutMapper recordOutMapper;
    @Resource
    private RecordStockMapper recordStockMapper;

    @Override
    public void addRecordOut(RecordOut recordOut) {
        System.out.println("仓库id:" + recordOut.getProductId());
        System.out.println("产品id:" + recordOut.getRepoId());
        System.out.println("recordOut1:" + recordOut);
        int repoId = recordOut.getRepoId();
        int productId = recordOut.getProductId();
        RecordStock recordStockOne1 = recordStockMapper.getRecordStockOne1(repoId, productId);
        System.out.println("关联表数据：" + recordStockOne1);
        //List<RecordStock> recordStockList = recordStockMapper.getRecordStockList(repoId, productId);
        RecordStock recordStock = new RecordStock();
        recordStock.setProductId(recordOut.getProductId());//仓库id
        recordStock.setRepoId(recordOut.getRepoId());//产品id
        if (recordStockOne1 != null) {
            recordStock.setProductStock(recordStockOne1.getProductStock() - recordOut.getRecordOutNumber());//修改仓库、产品关联表中的库存数量
            System.out.println("原有库存库存：" + recordStockOne1.getProductStock());
            System.out.println("删除库存：" + recordOut.getRecordOutNumber());
            System.out.println("recordStock更新前数据:" + recordStock);
            recordStock.setIsDelete(recordStock.getIsDelete());//是否删除
            recordStock.setCreateTime(recordStock.getCreateTime());//创建时间
            recordStock.setUpdateTime(new Date());//更新时间
            recordStockMapper.updateRecordStock(recordStock);
        } else {
            recordStock.setProductStock(recordOut.getRecordOutNumber());//修改仓库、产品关联表中的库存数量
            recordStock.setIsDelete(recordOut.getIsDelete());//是否删除
            recordStock.setCreateTime(new Date());//创建时间
            recordStock.setUpdateTime(new Date());//更新时间
            System.out.println("recordStock添加前数据:" + recordStock);
            recordStockMapper.addRecordStock(recordStock);
        }
        recordOut.setRecordOutTime(new Date());
        recordOut.setUpdateTime(new Date());
        recordOut.setCreateTime(new Date());
        recordOutMapper.addRecordOut(recordOut);
    }
}
