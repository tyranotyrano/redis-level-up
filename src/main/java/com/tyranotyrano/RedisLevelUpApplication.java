package com.tyranotyrano;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class RedisLevelUpApplication {

    public static void main(String[] args) {
        SpringApplication.run(RedisLevelUpApplication.class, args);
    }

}
