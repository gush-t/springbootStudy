package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.Entity.Student;

import java.util.List;

public interface StudentService {

    Student findById(Integer stuId);

    /**
     *
     * @param stuName
     * @param stuClass
     * @return
     */
    //Student findByStuNameAndClass(String stuName ,String stuClass);

    /**
     * @param page
     * @param size
     * @param stuClass
     * @return
     */
    Page<Student> findStudentByClass(int page, int size, String stuClass);

    /**
     * 新增或者修改
     *
     * @param stu
     */
    void save(Student stu);

    /**
     * 删除
     *
     * @param stuId
     */
    void deleteById(Integer stuId);

    List<Student> findAll();


}
