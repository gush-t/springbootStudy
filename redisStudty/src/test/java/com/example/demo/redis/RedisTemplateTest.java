package com.example.demo.redis;


import com.example.demo.entity.User;
import com.sun.beans.decoder.ValueObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Autowired
    private RedisTemplate<String, String> stringRedisTemplate;

    @Test
    public void redisTemplateTest() {
        //String
        ValueOperations<String, Object> valueObject = redisTemplate.opsForValue();
        valueObject.set("hello", new User("1", "Tom"));
        System.out.println(valueObject.get("hello"));
        HashOperations<String, String, Object> hashOperations = redisTemplate.opsForHash();
        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("hello", "world");
        map.put("hello1", "world1");
        map.put("hello2", "world2");
        hashOperations.putAll("table", map);
        String str = (String) hashOperations.get("table", "hello2");
        Assertions.assertEquals("world2", str);
        Set<String> set = hashOperations.keys("table");
        set.stream().forEach(System.out::println);
        List<Object> list = hashOperations.values("table");
        list.stream().forEach(System.out::println);

    }
}
