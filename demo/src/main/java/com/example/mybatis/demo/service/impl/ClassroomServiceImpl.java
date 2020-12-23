package com.example.mybatis.demo.service.impl;

import com.example.mybatis.demo.entity.Classroom;
import com.example.mybatis.demo.mapper.ClassroomMapper;
import com.example.mybatis.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassroomServiceImpl implements ClassroomService {

    @Autowired
    private ClassroomMapper classroomMapper;

    @Override
    public List<Classroom> findAll() {
        return classroomMapper.findAll();
    }
}
