package com.test.base.demo.service.impl;

import com.test.base.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class UserServiceImpl implements UserService {

    ExecutorService executorService = Executors.newSingleThreadExecutor();

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
}
