package com.test.base.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author liguanghui9105
 */
@SpringBootApplication
@MapperScan("com.test.base.demo.mapper")
public class BaseCodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCodeApplication.class, args);
    }

}
