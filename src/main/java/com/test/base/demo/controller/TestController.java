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

    @RequestMapping("/getName")
    public String getName(){
        return userService.getUserName(1L);
    }

}
