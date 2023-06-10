package qf.com.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import qf.com.dto.Page;
import qf.com.entity.Industry;
import qf.com.service.IndustryService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 12:12
 * @version：1.0
 */
public class IndustryServiceTest {
    ApplicationContext ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
    IndustryService industryService = ioc.getBean(IndustryService.class);
    @Test
    public void addIndustry() {
        Industry industry = new Industry();
        industry.setIndustryId(6);
        industry.setIndustryName("行业名称");
        industry.setCreateTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIsDelete(1);
        industryService.addIndustry(industry);
    }

    @Test
    public void deleteIndustry() {
        industryService.deleteIndustry(9);
    }

    @Test
    public void batchIndustry() {
        List<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        industryService.batchIndustry(list);
    }

    @Test
    public void updateIndustry() {
        Industry industry = new Industry();
        industry.setIndustryId(9);
        industry.setIndustryName("11行业名称11");
        industry.setCreateTime(new Date());
        industry.setUpdateTime(new Date());
        industry.setIsDelete(1);
        industryService.updateIndustry(industry);
    }

    @Test
    public void getIndustryList() {
        Page industryList = industryService.getIndustryList(1, 5);
        System.out.println(industryList);
    }

    @Test
    public void getIndustryOne() {
        Industry industryOne = industryService.getIndustryOne(6);
        System.out.println(industryOne);
    }
}
