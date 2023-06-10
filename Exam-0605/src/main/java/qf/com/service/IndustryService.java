package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Industry;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 11:45
 * @version：1.0
 */
public interface IndustryService {
    //增加
    void addIndustry(Industry industry);
    //删除
    void deleteIndustry(Integer industryId);
    //批量删除
    void batchIndustry(List<Integer> industryId);
    //更改
    void updateIndustry(Industry industry);
    //查询列表
    Page getIndustryList(Integer pageNo, Integer pageSize);
    //查询单个
    Industry getIndustryOne(Integer industryId);
    //查询列表
    List<Industry> getList();
}
