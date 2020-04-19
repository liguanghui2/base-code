package com.test.base.demo.controller;

import com.test.base.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    public String test() {
        return "hello";
    }

    /**
     * 将名字和价格一起作为一个字符串返回
     * 例如:小明99
     * 查询价格远程接口的时候要用线程池异步调用
     *
     * @return
     */
    @RequestMapping("/getUserNameAndPrice")
    public String getUserNameAndPrice() {
        return userService.getUserNameAndPrice(1L);
    }



    @RequestMapping("/getName")
    public String getName() {
        return userService.getUserName(1L);
    }

}
