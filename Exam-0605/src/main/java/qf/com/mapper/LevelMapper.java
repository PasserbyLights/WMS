package qf.com.mapper;

import qf.com.entity.Level;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 20:21
 * @version：1.0
 */
public interface LevelMapper {
    //添加
    void addLevel(Level level);
    //删除
    void deleteLevel(Integer levelId);
    //更改
    void updateLevel(Level level);
    //查询单个
    Level getLevelOne(Integer levelId);
    //查询多个
    List<Level> getLevelList();

}
