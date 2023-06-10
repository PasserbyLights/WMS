package qf.com.mapper;

import qf.com.entity.Industry;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 10:48
 * @version：1.0
 */
public interface IndustryMapper {
    //增加
    void addIndustry(Industry industry);
    //删除
    void deleteIndustry(Integer industryId);
    //批量删除
    void batchIndustry(List<Integer> industryId);
    //更改
    void updateIndustry(Industry industry);
    //查询列表
    List<Industry> getIndustryList();
    //查询单个
    Industry getIndustryOne(Integer industryId);
}
