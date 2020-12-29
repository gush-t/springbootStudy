package com.example.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.Student;
import com.example.demo.manager.IStudentDaoMgr;
import com.example.demo.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDaoMgr studentDaoMgr;

    @Override
    public List<Student> findAllStudent() {

        return studentDaoMgr.findAllStu();
    }

}
