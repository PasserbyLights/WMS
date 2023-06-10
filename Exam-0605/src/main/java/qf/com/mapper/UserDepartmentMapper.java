package qf.com.mapper;

import qf.com.entity.UserDepartment;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 12:36
 * @version：1.0
 */
public interface UserDepartmentMapper {
    void addUserDepartment(UserDepartment userDepartment);

    void deleteUserDepartment(Integer deptId);

    UserDepartment getUserDepartmentOne(Integer userId);

    List<UserDepartment> getUserDepartmentList();
}
