package com.example.demo.redis;


import com.example.demo.entity.User;
import com.sun.beans.decoder.ValueObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;


@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Autowired
    private  RedisTemplate<String,String> stringRedisTemplate;

    @Test
    public void redisTemplateTest(){
        //String
        ValueOperations<String,Object> valueObject= redisTemplate.opsForValue();
        valueObject.set("hello",new User("1","Tom"));
        System.out.println(valueObject.get("hello"));
    }
}
