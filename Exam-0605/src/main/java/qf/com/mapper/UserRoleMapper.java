package qf.com.mapper;

import qf.com.entity.UserRole;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 11:54
 * @version：1.0
 */
public interface UserRoleMapper {
    void addUserRole(UserRole userRole);
    void deleteUserRole(Integer userId);
    UserRole getUserRoleOne(Integer roleId);
    List<UserRole> getUserRoleList();
}
