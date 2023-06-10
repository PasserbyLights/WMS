package qf.com.mapper;

import org.apache.ibatis.annotations.Param;
import qf.com.entity.User;

import java.util.Date;
import java.util.List;

/**
 * @author：DengHaiWen
 * @date：2023/6/7 12:51
 * @version：1.0
 */
public interface UserMapper {
    User getAdmin(@Param(value = "userEmail") String userEmail,@Param(value = "password") String password);

    void addUser(User user);

    void deleteUser(Integer userId);

    void updateUser(User user);

    User getUserOne(Integer userId);

    User getUserOne1(Integer userId);

    List<User> getUserList(@Param("userName") String userName,
                           @Param("userTel") String userTel,
                           @Param("startTime") Date startTime,
                           @Param("endTime") Date endTime);
    User getUserByEmail(String userEmail);
}
