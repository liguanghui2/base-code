package com.test.base.demo.service;


import com.test.base.demo.bean.user.User;

import java.util.List;

/**
 * @author liguanghui9105
 */
public interface UserService {

    /**
     * 根据ID查询用户
     *
     * @param userId
     * @return
     */
    String getUserName(Long userId);

    /**
     * 根据用户ID查询用户名字和价格
     *
     * @param userId
     * @return
     */
    String getUserNameAndPrice(Long userId);

    /**
     * 根据用户编号获取用户信息
     *
     * @param userNum
     * @return
     */
    User getUserByUserNum(Integer userNum);

    /**
     * 新增用户
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
