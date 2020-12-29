package com.example.mybatis.demo.mapper;

import com.example.mybatis.demo.entity.Classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassroomMapper {

    List<Classroom> findAll();

    Classroom findByClassNo(String classNo);

    int deleteClassroom(String classNo);

    int updateClassroom(Classroom classroom);

    int insertClassroom(Classroom classroom);


}
