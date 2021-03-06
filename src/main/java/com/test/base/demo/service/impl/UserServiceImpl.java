package com.test.base.demo.service.impl;

import com.test.base.demo.bean.user.User;
import com.test.base.demo.mapper.user.UserMapper;
import com.test.base.demo.price.remote.PriceRemoteService;
import com.test.base.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.*;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PriceRemoteService priceRemoteService;
    @Autowired
    private UserMapper userMapper;

    ExecutorService executorService = Executors.newSingleThreadExecutor();
    ExecutorService fixService = Executors.newFixedThreadPool(10);
    ExecutorService cacheService = Executors.newCachedThreadPool();

    @Override
    public String getUserName(Long userId) {
        if (userId == 1) {
            System.out.println("方法進入");
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("hello");
                }
            });
            Future<String> submit = executorService.submit(new Callable<String>() {
                @Override
                public String call() {
                    return "神秘的人";
                }
            });
            String name = null;
            try {
                name = submit.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return name;
        } else {
            return "小花";
        }
    }

    @Override
    public String getUserNameAndPrice(Long userId) {
        if (userId == 1) {
            System.out.println("START");
            Future<BigDecimal> submit = executorService.submit(new Callable<BigDecimal>() {
                @Override
                public BigDecimal call() {
                    BigDecimal price = priceRemoteService.getPriceById(userId);
                    return price;
                }
            });
            String nameAndPrice = null;
            try {
                nameAndPrice = "小明" + submit.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return nameAndPrice;
        } else {
            return "没有名字哈哈哈";
        }
    }

    @Override
    public User getUserByUserNum(Integer userNum) {
        return null;
    }

    @Override
    public Long addUser(User user) {
        userMapper.addUser(user);
        return user.getId();
    }

    @Override
    public List<User> selectUsersByUserNum(Integer userNum) {
        List<User> users = userMapper.selectUsersByUserNum(userNum);
        return users;
    }
}
