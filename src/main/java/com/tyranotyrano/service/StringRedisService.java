package com.tyranotyrano.service;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.tyranotyrano.rqrs.CreateStringCacheRq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StringRedisService {

    private final StringRedisTemplate stringRedisTemplate;

    public String findByKey(String key) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void create(CreateStringCacheRq rq) {
        ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
        valueOperations.set(rq.getKey(), rq.getValue());
    }
}
