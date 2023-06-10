package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.Carrier;
import qf.com.entity.Department;
import qf.com.mapper.DepartmentMapper;
import qf.com.service.DepartmentService;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 11:55
 * @version：1.0
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentMapper departmentMapper;

    @Override
    public void addDepartment(Department department) {
        departmentMapper.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer deptId) {
        departmentMapper.deleteDepartment(deptId);
    }

    @Override
    public void updateDepartment(Department department) {
        departmentMapper.updateDepartment(department);
    }

    @Override
    public Department getDepartmentOne(Integer deptId) {
        return departmentMapper.getDepartmentOne(deptId);
    }

    @Override
    public Page getDepartmentList(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo, pageSize);
        List<Department> departmentList = departmentMapper.getDepartmentList();

        PageInfo info = new PageInfo(departmentList);
        Page page = new Page();
        page.setPageNo(info.getPageNum());//当前页
        page.setPageSize(info.getPageSize());//页容量
        page.setPageCount(info.getPages());//总页数
        page.setTotal(info.getTotal());//总记录数
        page.setData(info.getList());//当前页
        page.setHasPre(info.isHasPreviousPage());//是否有上一页
        page.setHasNext(info.isHasNextPage());//是否有下一页
        return page;
    }

    @Override
    public List<Department> getListDepartment() {
        return departmentMapper.getDepartmentList();
    }
}
