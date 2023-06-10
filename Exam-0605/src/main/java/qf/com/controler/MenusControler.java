package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;
import qf.com.entity.Department;
import qf.com.entity.Menus;
import qf.com.service.MenusService;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 14:31
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class MenusControler {
    @Resource
    private MenusService menusService;
    @RequestMapping(value = "/addMenus")
    public Result addMenus(@RequestBody Menus menus) {
        menus.setUpdateTime(new Date());
        menusService.addMenus(menus);
        return new Result();
    }

    @RequestMapping(value = "/deleteMenus")
    public Result deleteMenus(Integer menuId) {
        menusService.deleteMenus(menuId);
        return new Result();
    }

    @RequestMapping(value = "/updateMenus")
    public Result updateMenus(@RequestBody Menus menus) {
        menus.setUpdateTime(new Date());
        menusService.updateMenus(menus);
        return new Result();
    }

    @RequestMapping(value = "/getMenusOne")
    public Result getMenusOne(Integer menuId) {
        Menus menusOne = menusService.getMenusOne(menuId);
        return new Result(menusOne);
    }
    @RequestMapping(value = "/getMenusList")
    public Result getMenusList(Integer pageNo,Integer pageSize) {
        Page departmentList = menusService.getMenusList(pageNo, pageSize);
        return new Result(departmentList);
    }
}
