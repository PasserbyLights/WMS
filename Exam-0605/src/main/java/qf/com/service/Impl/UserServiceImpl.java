package qf.com.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import qf.com.dto.Page;
import qf.com.entity.User;
import qf.com.entity.UserDepartment;
import qf.com.entity.UserRole;
import qf.com.mapper.UserDepartmentMapper;
import qf.com.mapper.UserMapper;
import qf.com.mapper.UserRoleMapper;
import qf.com.service.UserService;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 12:55
 * @version：1.0
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDepartmentMapper userDepartmentMapper;
    @Resource
    private UserRoleMapper userRoleMapper;

    @Override
    public User getAdmin(String userEmail, String password) {
        return userMapper.getAdmin(userEmail, password);
    }

    @Override
    public User getUserByEmail(String userEmail) {
        return userMapper.getUserByEmail(userEmail);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);

        UserDepartment userDepartment = new UserDepartment();
        userDepartment.setCreateTime(user.getCreateTime());
        userDepartment.setUpdateTime(user.getUpdateTime());
        userDepartment.setIsDelete(user.getIsDelete());
        userDepartment.setUserId(user.getUserId());
        List<Integer> deptId = user.getDeptId();
        for (Integer integer : deptId) {
            userDepartment.setDeptId(integer);
            System.out.println("userDepartment:" + userDepartment);
            userDepartmentMapper.addUserDepartment(userDepartment);
        }

        UserRole userRole = new UserRole();
        userRole.setCreateTime(user.getCreateTime());
        userRole.setUpdateTime(user.getUpdateTime());
        userRole.setIsDelete(user.getIsDelete());
        userRole.setUserId(user.getUserId());
        List<Integer> roleId = user.getRoleId();
        for (Integer integer : roleId) {
            userRole.setRoleId(integer);
            userRoleMapper.addUserRole(userRole);
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        userMapper.deleteUser(userId);
        userDepartmentMapper.deleteUserDepartment(userId);
        userRoleMapper.deleteUserRole(userId);
    }

    @Override
    public void updateUser(User user) {
        userMapper.updateUser(user);
    }

    @Override
    public User getUserOne(Integer userId) {
        return userMapper.getUserOne(userId);
    }

    @Override
    public User getUserOne1(Integer userId) {
        return userMapper.getUserOne1(userId);
    }

    @Override
    public Page getUserList(Integer pageNo, Integer pageSize, String userName, String userTel, Date startTime, Date endTime) {
        PageHelper.startPage(pageNo, pageSize);
        List<User> users = userMapper.getUserList(userName, userTel, startTime, endTime);

        PageInfo info = new PageInfo(users);
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
}
