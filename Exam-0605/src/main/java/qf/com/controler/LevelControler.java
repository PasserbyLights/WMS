package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Industry;
import qf.com.entity.Level;
import qf.com.mapper.LevelMapper;
import qf.com.service.LevelService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 21:01
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class LevelControler {
    @Resource
    private LevelService levelService;

    @RequestMapping(value = "/addLevel")
    public Result addLevel(@RequestBody Level level) {
        level.setUpdateTime(new Date());
        levelService.addLevel(level);
        return new Result();
    }
    @RequestMapping(value = "/deleteLevel")
    public Result deleteLevel(Integer levelId) {
        levelService.deleteLevel(levelId);
        return new Result();
    }
    @RequestMapping(value = "/updateLevel")
    public Result updateLevel(@RequestBody Level level) {
        level.setUpdateTime(new Date());
        levelService.updateLevel(level);
        return new Result();
    }
    @RequestMapping(value = "/getLevelOne")
    public Result getLevelOne(Integer levelId) {
        Level levelOne = levelService.getLevelOne(levelId);
        return new Result(levelOne);
    }
    @RequestMapping(value = "/getLevelList")
    public Result getLevelList(Integer pageNo,Integer pageSize) {
        Page levelList = levelService.getLevelList(pageNo,pageSize);
        return new Result(levelList);
    }
    @RequestMapping(value = "/getListLevel")
    public Result getListLevel() {
        List<Level> list = levelService.getList();
        return new Result(list);
    }
}
