package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Industry;
import qf.com.mapper.IndustryMapper;
import qf.com.service.IndustryService;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 11:45
 * @version：1.0
 */
@Transactional
@Service
public class IndustryServiceImpl implements IndustryService {

    @Resource
    private IndustryMapper industryMapper;

    @Override
    public void addIndustry(Industry industry) {
        industryMapper.addIndustry(industry);
    }

    @Override
    public void deleteIndustry(Integer industryId) {
        industryMapper.deleteIndustry(industryId);
    }

    @Override
    public void batchIndustry(List<Integer> industryId) {
        industryMapper.batchIndustry(industryId);
    }

    @Override
    public void updateIndustry(Industry industry) {
        industryMapper.updateIndustry(industry);
    }

    @Override
    public Page getIndustryList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Industry> industryList = industryMapper.getIndustryList();

        PageInfo info = new PageInfo(industryList);
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
    public Industry getIndustryOne(Integer industryId) {
        return industryMapper.getIndustryOne(industryId);
    }

    @Override
    public List<Industry> getList() {
        return industryMapper.getIndustryList();
    }
}
