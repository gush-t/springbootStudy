package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "student")
@Entity
public class Student implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "`stuId`")
    public Integer stuId;

    @Column(name = "`STUNAME`")
    public String stuName;

    @Column(name = "`STUCLASS`")
    public String stuClass;
    @Column(name = "`STUSEX`")
    public String stuSex;
    @Column(name = "`STUAGE`")
    public Integer stuAge;

    public Student() {
        super();
    }


    public Student(Integer stuId, String stuName, String stuClass, String stuSex, Integer stuAge) {
        super();
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuClass = stuClass;
        this.stuSex = stuSex;
        this.stuAge = stuAge;
    }

    @Override
    public String toString() {
        return "Student [stuId=" + stuId + ", stuName=" + stuName + ", stuClass=" + stuClass + ", stuSex=" + stuSex
                + ", stuAge=" + stuAge + "]";
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuClass() {
        return stuClass;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public Integer getStuAge() {
        return stuAge;
    }

    public void setStuAge(Integer stuAge) {
        this.stuAge = stuAge;
    }


}
