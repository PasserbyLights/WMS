package qf.com.mapper;

import qf.com.entity.Department;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/6 11:52
 * @version：1.0
 */
public interface DepartmentMapper {
    void addDepartment(Department department);

    void deleteDepartment(Integer deptId);

    void updateDepartment(Department department);

    Department getDepartmentOne(Integer deptId);

    List<Department> getDepartmentList();
}
