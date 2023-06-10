package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Level;
import qf.com.entity.Source;
import qf.com.mapper.SourceMapper;
import qf.com.service.SourceService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 21:29
 * @version：1.0
 */
@Service
@Transactional
public class SourceServiceImpl implements SourceService {
    @Resource
    private SourceMapper sourceMapper;
    @Override
    public void addSource(Source source) {
        sourceMapper.addSource(source);
    }

    @Override
    public void deleteSource(Integer sourceId) {
        sourceMapper.deleteSource(sourceId);
    }

    @Override
    public void updateSource(Source source) {
        sourceMapper.updateSource(source);
    }

    @Override
    public Source getSourceOne(Integer sourceId) {
        return sourceMapper.getSourceOne(sourceId);
    }

    @Override
    public Page getSourceList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Source> sources = sourceMapper.getSourceList();

        PageInfo info = new PageInfo(sources);
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
    public List<Source> getList() {
        return sourceMapper.getSourceList();
    }
}
