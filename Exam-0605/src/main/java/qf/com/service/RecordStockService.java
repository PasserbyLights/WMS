package qf.com.service;

import org.apache.ibatis.annotations.Param;
import qf.com.dto.Page;
import qf.com.entity.RecordStock;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/8 9:31
 * @version：1.0
 */
public interface RecordStockService {
    //添加
    void addRecordStock(RecordStock recordStock);

    //更新
    void updateRecordStock(RecordStock recordStock);

    //查询多个
    Page getRecordStockList(@Param("repoId") Integer repoId,
                            @Param("productId") Integer productId,
                            @Param("pageNo") Integer pageNo,
                            @Param("pageSize") Integer pageSize);

    //查询多个
    /*RecordStock getRecordStockOne(Integer productId,Integer repoId);*/
    List<RecordStock> getRecordStockList(@Param("repoId") Integer repoId,
                                         @Param("productId") Integer productId);

    RecordStock getListStockRecord(@Param("repoId") Integer repoId,
                                   @Param("productId") Integer productId);

    List<RecordStock> getRecordStockOne(Integer productId);

    RecordStock getRecordStockOne1(Integer repoId, Integer productId);
}
