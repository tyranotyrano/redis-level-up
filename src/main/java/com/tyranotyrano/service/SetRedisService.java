package com.tyranotyrano.service;

import java.util.Set;

import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import com.tyranotyrano.rqrs.CreateStringCacheRq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetRedisService {
    private final StringRedisTemplate stringRedisTemplate;

    public void create(CreateStringCacheRq rq) {
        SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
        setOperations.add(rq.getKey(), rq.getValue());
    }

    public String findByKey(String key) {
        SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
        return setOperations.pop(key);
    }

    public Set<String> findAll(String key) {
        SetOperations<String, String> setOperations = stringRedisTemplate.opsForSet();
        return setOperations.members(key);
    }
}
