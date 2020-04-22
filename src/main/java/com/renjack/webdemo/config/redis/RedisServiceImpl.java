package com.renjack.webdemo.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void set(final String key, final String value, final long expire, final TimeUnit unit) {
        this.redisTemplate.opsForValue().set(key, value, expire, unit);
    }

    @Override
    public String get(final String key) {
        BoundValueOperations boundValueOperations = this.stringRedisTemplate.boundValueOps(key);
        return (String)boundValueOperations.get();
    }

    @Override
    public boolean expire(final String key, final long expire) {
        this.stringRedisTemplate.expire(key, expire, TimeUnit.SECONDS);
        return false;
    }

    @Override
    public boolean remove(final String key) {
        return false;
    }
}
