package com.tyranotyrano.service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.tyranotyrano.rqrs.CreateCacheRq;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ObjectRedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public Object findByKey(String key) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    public void create(CreateCacheRq rq) {
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(rq.getKey(), rq.getValue());
    }
}
