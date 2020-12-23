package com.example.mybatis.demo.controller;

import com.example.mybatis.demo.entity.Classroom;
import com.example.mybatis.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("classroom/")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("all")
    @ResponseBody
    public List<Classroom> findAll(){
        return classroomService.findAll();
    }

}
