package qf.com.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import qf.com.dto.Page;
import qf.com.dto.Result;

import qf.com.entity.Department;
import qf.com.service.DepartmentService;


import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 12:34
 * @version：1.0
 */
@CrossOrigin
@Controller
@ResponseBody
public class DepartmentControler {
    @Resource
    private DepartmentService departmentService;
    @RequestMapping(value = "/addDepartment")
    public Result addDepartment(@RequestBody Department department) {
        department.setUpdateTime(new Date());
        departmentService.addDepartment(department);
        return new Result();
    }

    @RequestMapping(value = "/deleteDepartment")
    public Result deleteDepartment(Integer deptId) {
        departmentService.deleteDepartment(deptId);
        return new Result();
    }

    @RequestMapping(value = "/updateDepartment")
    public Result updateDepartment(@RequestBody Department department) {
        department.setUpdateTime(new Date());
        departmentService.updateDepartment(department);
        return new Result();
    }

    @RequestMapping(value = "/getDepartmentOne")
    public Result getDepartmentOne(Integer deptId) {
        Department departmentOne = departmentService.getDepartmentOne(deptId);
        return new Result(departmentOne);
    }
    @RequestMapping(value = "/getDepartmentList")
    public Result getDepartmentList(Integer pageNo,Integer pageSize) {
        Page departmentList = departmentService.getDepartmentList(pageNo, pageSize);
        return new Result(departmentList);
    }
    @RequestMapping(value = "/getListDepartment")
    public Result getListDepartment() {
        List<Department> listDepartment = departmentService.getListDepartment();
        return new Result(listDepartment);
    }
}
