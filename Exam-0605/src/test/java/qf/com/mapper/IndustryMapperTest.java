package qf.com.mapper;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.entity.Industry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 11:10
 * @version：1.0
 */
public class IndustryMapperTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    IndustryMapper industryMapper = ioc.getBean(IndustryMapper.class);

    @Test
    public void addIndustry() {
        Industry industry = new Industry();
        industry.setIndustryName("行业名称");
        industry.setCreateTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIsDelete(1);
        industryMapper.addIndustry(industry);
    }

    @Test
    public void deleteIndustry() {
        industryMapper.deleteIndustry(6);
    }

    @Test
    public void updateIndustry() {
        Industry industry = new Industry();
        industry.setIndustryId(6);
        industry.setIndustryName("行业名称");
        industry.setCreateTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIsDelete(1);
        industryMapper.updateIndustry(industry);
    }

    @Test
    public void getIndustryIdOne() {
        Industry industryIdOne = industryMapper.getIndustryOne(6);
        System.out.println(industryIdOne);
    }

    @Test
    public void getIndustryList() {
        List<Industry> industryList = industryMapper.getIndustryList();
        for (Industry industry : industryList) {
            System.out.println(industry);
        }
    }
    @Test
    public void batchIndustry() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        industryMapper.batchIndustry(list);
    }

}
