package com.example.mybatis.demo.controller;

import com.example.mybatis.demo.entity.Classroom;
import com.example.mybatis.demo.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("classroom/")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @GetMapping("all/")
    @ResponseBody
    public List<Classroom> findAll(){
        return classroomService.findAll();
    }

    @GetMapping
    @ResponseBody
    public Classroom findByClassNo(@RequestParam String classNo) {
        return classroomService.findByClassNo(classNo);
    }

    @PostMapping
    @ResponseBody
    public void insertClassroom(@RequestBody Classroom classroom){
        classroomService.insertClassroom(classroom);
    }

    @PutMapping
    @ResponseBody
    public  void updateClassroom(@RequestBody Classroom classroom){
        classroomService.updateClassroom(classroom);
    }

    @DeleteMapping
    @ResponseBody
    public void deleteClassroom(@RequestParam String classNo){
        classroomService.deleteClassroom(classNo);
    }
}
