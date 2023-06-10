package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Department;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 11:54
 * @version：1.0
 */
public interface DepartmentService {
    void addDepartment(Department department);

    void deleteDepartment(Integer deptId);

    void updateDepartment(Department department);

    Department getDepartmentOne(Integer deptId);

    Page getDepartmentList(Integer pageNo, Integer pageSize);

    List<Department> getListDepartment();
}
