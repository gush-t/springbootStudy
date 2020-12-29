package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.criteria.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Student;
import com.example.demo.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentDao studentDao;


    @Override
    public Page<Student> findStudentByClass(int page, int size, String stuClass) {
        Sort sort = Sort.by(Sort.Direction.DESC, "stuClass");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Student> findStudentByClass = studentDao.findStudentByClass((Specification<Student>) (root, criteriaQuery, criteriaBuilder) -> {
            Predicate equal = criteriaBuilder.equal(root.get("stuClass"), stuClass);
            return criteriaBuilder.and(equal);
        }, pageable);
        return findStudentByClass;
    }

    @Override
    public void save(Student stu) {
        studentDao.save(stu);
    }

    @Override
    public void deleteById(Integer stuId) {
        studentDao.deleteById(stuId);
    }

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }

    @Override
    public Student findById(Integer stuId) {
        Optional<Student> findById = studentDao.findById(stuId);
        return findById.orElse(new Student(01, "谷少華", "20201415班", "男", 19));
    }

}
