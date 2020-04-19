package com.test.base.demo.service;

import java.util.concurrent.ExecutionException;

public interface UserService {

    String getUserName(Long userId);
    String getUserNameAndPrice(Long userId);
}
