package com.example.mybatis.demo.controller;

import com.example.mybatis.demo.entity.Classroom;
import com.example.mybatis.demo.service.ClassroomService;
import com.rabbitmq.client.Return;
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
    public int insertClassroom(@RequestBody Classroom classroom){
       return classroomService.insertClassroom(classroom);
    }

    @PutMapping
    @ResponseBody
    public  int updateClassroom(@RequestBody Classroom classroom){
       return classroomService.updateClassroom(classroom);
    }

    @DeleteMapping
    @ResponseBody
    public int deleteClassroom(@RequestParam String classNo){
       return   classroomService.deleteClassroom(classNo);
    }
}
