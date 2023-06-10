package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.RecordStock;
import qf.com.entity.User;
import qf.com.mapper.RecordStockMapper;
import qf.com.service.RecordStockService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/8 9:33
 * @version：1.0
 */
@Service
@Transactional
public class RecordStockServiceImpl implements RecordStockService {
    @Resource
    private RecordStockMapper recordStockMapper;

    @Override
    public void addRecordStock(RecordStock recordStock) {
        recordStockMapper.addRecordStock(recordStock);
    }

    @Override
    public void updateRecordStock(RecordStock recordStock) {
        recordStockMapper.updateRecordStock(recordStock);
    }

    @Override
    public Page getRecordStockList(Integer pageNo, Integer pageSize, Integer repoId, Integer productId) {
        PageHelper.startPage(pageNo, pageSize);
        List<RecordStock> recordStocks = recordStockMapper.getRecordStockList(repoId, productId);

        PageInfo info = new PageInfo(recordStocks);
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
    public List<RecordStock> getRecordStockList(Integer repoId, Integer productId) {
        return recordStockMapper.getRecordStockList(repoId, productId);
    }

    @Override
    public RecordStock getListStockRecord(Integer repoId, Integer productId) {
        return recordStockMapper.getListStockRecord(repoId, productId);
    }

    @Override
    public List<RecordStock> getRecordStockOne(Integer productId) {
        return recordStockMapper.getRecordStockOne(productId);
    }

    @Override
    public RecordStock getRecordStockOne1(Integer repoId, Integer productId) {
        return recordStockMapper.getRecordStockOne1(repoId, productId);
    }
}
