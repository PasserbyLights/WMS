package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Source;
import qf.com.mapper.LevelMapper;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 21:35
 * @version：1.0
 */
public class SourceServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    SourceService sourceService = ioc.getBean(SourceService.class);
    @Test
    public void addSource() {
        Source source = new Source();
        source.setSourceName("客户来源名称");
        source.setCreateTime(new Date());
        source.setUpdateTime(new Date());
        source.setIsDelete(1);
        sourceService.addSource(source);

    }

    @Test
    public void deleteSource() {
        sourceService.deleteSource(7);
    }

    @Test
    public void updateSource() {
        Source source = new Source();
        source.setSourceName("客户来源名称");
        source.setCreateTime(new Date());
        source.setUpdateTime(new Date());
        source.setIsDelete(1);
        source.setSourceId(7);
        sourceService.updateSource(source);
    }

    @Test
    public void getSourceOne() {
        Source sourceOne = sourceService.getSourceOne(7);
        System.out.println(sourceOne);
    }

    @Test
    public void getSourceList() {
        Page sourceList = sourceService.getSourceList(1, 5);
        System.out.println(sourceList);
    }
}
