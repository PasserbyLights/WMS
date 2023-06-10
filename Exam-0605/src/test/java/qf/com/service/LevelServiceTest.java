package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Level;
import qf.com.mapper.LevelMapper;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 20:34
 * @version：1.0
 */
public class LevelServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    LevelService levelService = ioc.getBean(LevelService.class);
    @Test
    public void addLevel() {
        Level level = new Level();
        level.setLevelName("客户测试数据1");
        level.setCreateTime(new Date());
        level.setUpdateTime(new Date());
        level.setIsDelete(1);
        levelService.addLevel(level);
    }

    @Test
    public void deleteLevel() {
        levelService.deleteLevel(4);
    }

    @Test
    public void updateLevel() {
        Level level = new Level();
        level.setLevelName("1客户测试数据1");
        level.setCreateTime(new Date());
        level.setUpdateTime(new Date());
        level.setIsDelete(1);
        level.setLevelId(4);
        levelService.updateLevel(level);
    }

    @Test
    public void getLevelOne() {
        Level levelOne = levelService.getLevelOne(3);
        System.out.println(levelOne);
    }

    @Test
    public void getLevelList() {
        Page levelList = levelService.getLevelList(1, 5);
        System.out.println(levelList);
    }
}
