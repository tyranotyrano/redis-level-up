package com.tyranotyrano.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyranotyrano.rqrs.CreateStringCacheRq;
import com.tyranotyrano.rqrs.CreateStringCacheWithExpirationRq;
import com.tyranotyrano.service.StringRedisService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/redis")
@RestController
@RequiredArgsConstructor
public class StringRedisController {

    private final StringRedisService redisService;

    @GetMapping(path = "/{key}")
    public String findByKey(@PathVariable(name = "key") String key) {
        return redisService.findByKey(key);
    }

    @PostMapping
    public void create(@RequestBody CreateStringCacheRq rq) {
        redisService.create(rq);
    }

    @PostMapping(path = "/expiration")
    public void createWithExpiration(@RequestBody CreateStringCacheWithExpirationRq rq) {
        redisService.createWithExpiration(rq);
    }
}
