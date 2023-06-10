package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Industry;
import qf.com.service.IndustryService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 12:24
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class IndustryControler {
    @Resource
    private IndustryService industryService;

    @RequestMapping(value = "/addIndustry")
    public Result addIndustry(@RequestBody Industry industry) {
        industry.setUpdateTime(new Date());
        industryService.addIndustry(industry);
        return new Result();
    }

    @RequestMapping(value = "/deleteIndustry")
    public Result deleteIndustry(Integer industryId) {
        industryService.deleteIndustry(industryId);
        return new Result();
    }

    @RequestMapping(value = "/batchIndustry")
    public Result batchIndustry(@RequestBody List<Integer> industryId) {
        System.out.println(industryId);
        industryService.batchIndustry(industryId);
        return new Result();
    }

    @RequestMapping(value = "/updateIndustry")
    public Result updateIndustry(@RequestBody Industry industry) {
        industry.setUpdateTime(new Date());
        industryService.updateIndustry(industry);
        return new Result();
    }

    @RequestMapping(value = "/getIndustryList")
    public Result getIndustryList(Integer pageNo, Integer pageSize) {
        Page industryList = industryService.getIndustryList(pageNo, pageSize);
        return new Result(industryList);
    }

    @RequestMapping(value = "/getIndustryOne")
    public Result getIndustryOne(Integer industryId) {
        Industry industryOne = industryService.getIndustryOne(industryId);
        return new Result(industryOne);
    }
    @RequestMapping(value = "/getListIndustry")
    public Result getList() {
        List<Industry> list = industryService.getList();
        return new Result(list);
    }
}
