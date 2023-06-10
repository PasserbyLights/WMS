package qf.com.mapper;

import qf.com.entity.Level;
import qf.com.entity.Source;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 21:27
 * @version：1.0
 */
public interface SourceMapper {
    //添加
    void addSource(Source source);
    //删除
    void deleteSource(Integer sourceId);
    //更改
    void updateSource(Source source);
    //查询单个
    Source getSourceOne(Integer sourceId);
    //查询多个
    List<Source> getSourceList();
}
