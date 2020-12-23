package com.example.mybatis.demo.mapper;

import com.example.mybatis.demo.entity.Classroom;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ClassroomMapper {

    List<Classroom> findAll();



}
