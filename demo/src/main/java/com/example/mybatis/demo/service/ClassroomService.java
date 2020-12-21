package com.example.mybatis.demo.service;

import com.example.mybatis.demo.entity.Classroom;

import java.util.List;


public interface ClassroomService {
    List<Classroom> findAll();
}
