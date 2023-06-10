package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Level;
import qf.com.mapper.LevelMapper;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 20:25
 * @version：1.0
 */
public interface LevelService {
    //添加
    void addLevel(Level level);

    //删除
    void deleteLevel(Integer levelId);

    //更改
    void updateLevel(Level level);

    //查询单个
    Level getLevelOne(Integer levelId);

    //查询多个
    Page getLevelList(Integer pageNo, Integer pageSize);

    List<Level> getList();
}
