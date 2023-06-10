package qf.com.mapper;

import qf.com.entity.Role;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 9:17
 * @version：1.0
 */
public interface RoleMapper {
    void addRole(Role role);
    void deleteRole(Integer roleId);
    void updateRole(Role role);
    Role getRoleOne(Integer roleId);
    List<Role> getRoleList();
}
