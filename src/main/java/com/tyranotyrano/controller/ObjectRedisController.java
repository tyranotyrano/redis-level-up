package com.tyranotyrano.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyranotyrano.rqrs.CreateCacheRq;
import com.tyranotyrano.service.ObjectRedisService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/redis/object")
@RestController
@RequiredArgsConstructor
public class ObjectRedisController {

    private final ObjectRedisService objectRedisService;

    @GetMapping(path = "/{key}")
    public Object findByKey(@PathVariable(name = "key") String key) {
        return objectRedisService.findByKey(key);
    }

    @PostMapping
    public void create(@RequestBody CreateCacheRq rq) {
        objectRedisService.create(rq);
    }

    @PostMapping(path = "/list/add")
    public void add(@RequestBody CreateCacheRq rq) {
        objectRedisService.add(rq);
    }

    @GetMapping(path = "/list/{key}")
    public Object findAll(@PathVariable(name = "key") String key) {
        return objectRedisService.findAll(key);
    }

    @PostMapping(path = "/hash/add")
    public void addHash(@RequestBody CreateCacheRq rq) {
        objectRedisService.addHash(rq);
    }

    @GetMapping(path = "/hash/{key}")
    public Object findAllHash(@PathVariable(name = "key") String key) {
        return objectRedisService.findAllHash(key);
    }
}
