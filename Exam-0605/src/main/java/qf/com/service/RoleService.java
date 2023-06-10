package qf.com.service;

import qf.com.dto.Page;
import qf.com.entity.Role;

import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 9:19
 * @version：1.0
 */
public interface RoleService {
    void addRole(Role role);
    void deleteRole(Integer roleId);
    void updateRole(Role role);
    Role getRoleOne(Integer roleId);
    List<Role> getListRole();
    Page getRoleList(Integer pageNo,Integer pageSize);
}
