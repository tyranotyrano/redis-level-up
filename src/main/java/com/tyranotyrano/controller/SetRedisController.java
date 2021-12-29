package com.tyranotyrano.controller;

import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyranotyrano.rqrs.CreateStringCacheRq;
import com.tyranotyrano.service.SetRedisService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/redis/set")
@RestController
@RequiredArgsConstructor
public class SetRedisController {
    private final SetRedisService setRedisService;

    @PostMapping
    public void create(@RequestBody CreateStringCacheRq rq) {
        setRedisService.create(rq);
    }

    @GetMapping(path = "/{key}")
    public String findByKey(@PathVariable(name = "key") String key) {
        return setRedisService.findByKey(key);
    }

    @GetMapping(path = "/all/{key}")
    public Set<String> findAll(@PathVariable(name = "key") String key) {
        return setRedisService.findAll(key);
    }
}
