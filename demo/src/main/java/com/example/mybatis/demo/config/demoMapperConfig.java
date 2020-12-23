package com.example.mybatis.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.example.mybatis.demo.mapper")
public class demoMapperConfig {
}
