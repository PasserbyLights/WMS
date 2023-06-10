package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Level;
import qf.com.entity.Source;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 21:28
 * @version：1.0
 */
public interface SourceService {
    //添加
    void addSource(Source source);
    //删除
    void deleteSource(Integer sourceId);
    //更改
    void updateSource(Source source);
    //查询单个
    Source getSourceOne(Integer sourceId);
    //查询多个
    Page getSourceList(Integer pageNo,Integer pageSize);

    List<Source> getList();
}
