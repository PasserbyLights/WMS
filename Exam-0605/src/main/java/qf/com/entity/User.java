package qf.com.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import qf.com.entity.UserDepartment;
import qf.com.entity.UserRole;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author：DengHaiWen
 * @date：2023/6/5 9:52
 * @version：1.0
 */

public class User {
    private Integer userId;//用户ID
    private String userName;//用户姓名
    private String userTel;//用户手机号
    private String userEmail;//用户邮箱
    private String userNick;//用户昵称
    private String password;//用户密码
    private String salt;//盐值
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;//创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;//更新时间
    private Integer isDelete;//是否删除0：删除；1：未删除
    private String avatar;//头像

    private List<UserDepartment> userDepartment;//用户部门表
    private List<Integer> deptId;
    private List<UserRole> userRole;//角色关联表
    private List<Integer> roleId;

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userTel='" + userTel + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userNick='" + userNick + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", isDelete=" + isDelete +
                ", avatar='" + avatar + '\'' +
                ", userDepartment=" + userDepartment +
                ", deptId=" + deptId +
                ", userRole=" + userRole +
                ", roleId=" + roleId +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserNick() {
        return userNick;
    }

    public void setUserNick(String userNick) {
        this.userNick = userNick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public List<UserDepartment>  getUserDepartment() {
        return userDepartment;
    }

    public void setUserDepartment(List<UserDepartment>  userDepartment) {
        this.userDepartment = userDepartment;
    }

    public List<Integer> getDeptId() {
        return deptId;
    }

    public void setDeptId(List<Integer> deptId) {
        this.deptId = deptId;
    }

    public List<UserRole> getUserRole() {
        return userRole;
    }

    public void setUserRole(List<UserRole> userRole) {
        this.userRole = userRole;
    }

    public List<Integer> getRoleId() {
        return roleId;
    }

    public void setRoleId(List<Integer> roleId) {
        this.roleId = roleId;
    }

    public User() {
    }

    public User(Integer userId, String userName, String userTel, String userEmail, String userNick, String password, String salt, Date createTime, Date updateTime, Integer isDelete, String avatar, List<UserDepartment>  userDepartment, List<Integer> deptId, List<UserRole> userRole, List<Integer> roleId) {
        this.userId = userId;
        this.userName = userName;
        this.userTel = userTel;
        this.userEmail = userEmail;
        this.userNick = userNick;
        this.password = password;
        this.salt = salt;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.isDelete = isDelete;
        this.avatar = avatar;
        this.userDepartment = userDepartment;
        this.deptId = deptId;
        this.userRole = userRole;
        this.roleId = roleId;
    }
}
