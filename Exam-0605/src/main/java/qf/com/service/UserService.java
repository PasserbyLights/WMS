package qf.com.service;

import org.apache.ibatis.annotations.Param;
import qf.com.dto.Page;
import qf.com.entity.User;

import java.util.Date;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 12:54
 * @version：1.0
 */
public interface UserService {

    User getAdmin(@Param(value = "userEmail") String userEmail, @Param(value = "password") String password);
    User getUserByEmail(String userEmail);
    void addUser(User user);

    void deleteUser(Integer userId);

    void updateUser(User user);

    User getUserOne(Integer userId);

    User getUserOne1(Integer userId);

    Page getUserList(Integer pageNo, Integer pageSize,
                     String userName, String userTel,
                     Date startTime, Date endTime);
}
