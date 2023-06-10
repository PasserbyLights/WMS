package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Level;
import qf.com.entity.Source;
import qf.com.service.LevelService;
import qf.com.service.SourceService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 21:41
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class SourceControler {
    @Resource
    private SourceService sourceService;

    @RequestMapping(value = "/addSource")
    public Result addSource(@RequestBody Source source) {
        source.setUpdateTime(new Date());
        sourceService.addSource(source);
        return new Result();
    }
    @RequestMapping(value = "/deleteSource")
    public Result deleteSource(Integer sourceId) {
        sourceService.deleteSource(sourceId);
        return new Result();
    }
    @RequestMapping(value = "/updateSource")
    public Result updateSource(@RequestBody Source source) {
        source.setUpdateTime(new Date());
        sourceService.updateSource(source);
        return new Result();
    }
    @RequestMapping(value = "/getSourceOne")
    public Result getSourceOne(Integer sourceId) {
        Source sourceOne = sourceService.getSourceOne(sourceId);
        return new Result(sourceOne);
    }
    @RequestMapping(value = "/getSourceList")
    public Result getSourceList(Integer pageNo,Integer pageSize) {
        Page sourceList = sourceService.getSourceList(pageNo,pageSize);
        return new Result(sourceList);
    }
    @RequestMapping(value = "/getListSource")
    public Result getList() {
        List<Source> list = sourceService.getList();
        return new Result(list);
    }
}
