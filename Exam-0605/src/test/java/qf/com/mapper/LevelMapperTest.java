package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.Level;
import qf.com.service.LevelService;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 20:40
 * @version：1.0
 */
public class LevelMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    LevelMapper levelMapper = ioc.getBean(LevelMapper.class);
    @Test
    public void addLevel() {
        Level level = new Level();
        level.setLevelName("客户测试数据1");
        level.setCreateTime(new Date());
        level.setUpdateTime(new Date());
        level.setIsDelete(1);
        levelMapper.addLevel(level);
    }

    @Test
    public void deleteLevel() {
    }

    @Test
    public void updateLevel() {
    }

    @Test
    public void getLevelOne() {
        Level levelOne = levelMapper.getLevelOne(1);
        System.out.println(levelOne);
    }

    @Test
    public void getLevelList() {
        List<Level> levelList = levelMapper.getLevelList();
        for (Level level : levelList) {
            System.out.println(level);
        }
    }
}
