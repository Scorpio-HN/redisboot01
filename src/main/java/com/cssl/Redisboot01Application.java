package com.cssl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
//@EnableCaching
public class Redisboot01Application {

    public static void main(String[] args) {
        SpringApplication.run(Redisboot01Application.class, args);
    }

   //增加了注释。什么时候去日本
}
