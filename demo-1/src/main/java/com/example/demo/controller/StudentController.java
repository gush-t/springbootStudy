package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.Student;
import com.example.demo.service.IStudentService;

@RestController
public class StudentController {

    @Autowired
    private IStudentService studentService;

    @RequestMapping(name = "/getAll")
    @ResponseBody
    public List<Student> getAllStudent() {

        return studentService.findAllStudent();


    }

}
