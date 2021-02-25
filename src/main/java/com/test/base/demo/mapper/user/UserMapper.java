package com.test.base.demo.mapper.user;

import com.test.base.demo.bean.user.User;

import java.util.List;

/**
 * @author 李光辉
 * @version 1.0
 * @date 2021/2/25 10:28
 */
public interface UserMapper {
    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    Long addUser(User user);

    /**
     * 根据用户编号查用户
     *
     * @param userNum
     * @return
     */
    List<User> selectUsersByUserNum(Integer userNum);
}
