package qf.com.service.Impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.entity.RecordIn;
import qf.com.entity.RecordStock;
import qf.com.mapper.RecordInMapper;
import qf.com.mapper.RecordStockMapper;
import qf.com.service.RecordInService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/8 15:19
 * @version：1.0
 */
@Service
@Transactional
public class RecordInServiceImpl implements RecordInService {
    @Resource
    private RecordInMapper recordInMapper;
    @Resource
    private RecordStockMapper recordStockMapper;

    @Override
    public void addRecordIn(RecordIn recordIn) {
        System.out.println("仓库id:" + recordIn.getProductId());
        System.out.println("产品id:" + recordIn.getRepoId());
        int repoId = recordIn.getRepoId();
        int productId = recordIn.getProductId();
        RecordStock recordStockList = recordStockMapper.getRecordStockOne1(repoId, productId);
        System.out.println("关联表数据：" + recordStockList);

        RecordStock recordStock = new RecordStock();
        recordStock.setProductId(recordIn.getProductId());//仓库id
        recordStock.setRepoId(recordIn.getRepoId());//产品id
        if (recordStockList != null) {
            recordStock.setProductStock(recordStockList.getProductStock() + recordIn.getRecordInNumber());//修改仓库、产品关联表中的库存数量
            System.out.println("原有库存库存：" + recordStockList.getProductStock());
            System.out.println("新增库存：" + recordIn.getRecordInNumber());
            System.out.println("recordStock更新前数据:" + recordStock);
            recordStock.setIsDelete(recordStockList.getIsDelete());//是否删除
            recordStock.setCreateTime(new Date());//创建时间
            recordStock.setUpdateTime(new Date());//更新时间
            recordStockMapper.updateRecordStock(recordStock);
        } else {
            recordStock.setProductStock(recordIn.getRecordInNumber());//修改仓库、产品关联表中的库存数量
            recordStock.setIsDelete(recordIn.getIsDelete());//是否删除
            recordStock.setCreateTime(new Date());//创建时间
            recordStock.setUpdateTime(new Date());//更新时间
            System.out.println("recordStock添加前数据:" + recordStock);
            recordStockMapper.addRecordStock(recordStock);
        }
        recordIn.setRecordInTime(new Date());
        recordIn.setUpdateTime(new Date());
        recordIn.setCreateTime(new Date());
        recordInMapper.addRecordIn(recordIn);
    }
}
