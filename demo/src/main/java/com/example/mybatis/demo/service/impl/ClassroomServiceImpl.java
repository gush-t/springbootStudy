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

    @Override
    public Classroom findByClassNo(String classNo) {

        return classroomMapper.findByClassNo(classNo);
    }

    @Override
    public int deleteClassroom(String classNo) {
        return classroomMapper.deleteClassroom(classNo);
    }

    @Override
    public int updateClassroom(Classroom classroom) {
        return classroomMapper.updateClassroom(classroom);
    }

    @Override
    public int insertClassroom(Classroom classroom) {
        return classroomMapper.insertClassroom(classroom);
    }
}
