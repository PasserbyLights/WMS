package qf.com.mapper;

import org.apache.ibatis.annotations.Param;
import qf.com.entity.RecordStock;
import qf.com.entity.Repository;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/8 9:27
 * @version：1.0
 */
public interface RecordStockMapper {
    //添加
    void addRecordStock(RecordStock recordStock);

    //更新
    void updateRecordStock(RecordStock recordStock);

    //查询多个
    List<RecordStock> getRecordStockList(@Param("repoId") Integer repoId,
                                         @Param("productId") Integer productId);

    RecordStock getListStockRecord(@Param("repoId") Integer repoId,
                                         @Param("productId") Integer productId);
    //查询多个
    RecordStock getRecordStockOne1(@Param("repoId") Integer productId, @Param("productId") Integer repoId);

    List<RecordStock> getRecordStockOne(Integer productId);

}
