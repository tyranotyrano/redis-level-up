package com.tyranotyrano.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tyranotyrano.domain.Person;
import com.tyranotyrano.rqrs.CreateStringCacheRq;
import com.tyranotyrano.service.CacheRedisService;

import lombok.RequiredArgsConstructor;

@RequestMapping(path = "/redis/cache")
@RestController
@RequiredArgsConstructor
public class CacheRedisController {

    private final CacheRedisService cacheRedisService;

    @GetMapping(path = "/{key}")
    public String findByKey(@PathVariable(name = "key") String key) {
        return cacheRedisService.findByKey(key);
    }

    @PostMapping
    public void create(@RequestBody CreateStringCacheRq rq) {
        cacheRedisService.create(rq);
    }

    @DeleteMapping("/{key}")
    public void delete(@PathVariable(name = "key") String key) {
        cacheRedisService.delete(key);
    }

    @GetMapping(path = "/person/{name}")
    public String findPerson(@PathVariable(name = "name") String name) {
        Person person = cacheRedisService.findPerson(name);
        return person.getName() + person.getAge();
    }

    @DeleteMapping(path = "/person/{name}")
    public void deletePerson(@PathVariable(name = "name") String name) {
        cacheRedisService.deletePerson(name);
    }
}
