package com.example.mybatis.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Classroom implements Serializable {

    private String className;

    private int classNo;

    private String school;

    private Date date;

    public Classroom() {
    }

    /**
     * @param className
     * @param classNo
     * @param school
     */
    public Classroom(String className, int classNo, String school) {
        this.className = className;
        this.classNo = classNo;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Classroom{" +
                "className='" + className + '\'' +
                ", classNo=" + classNo +
                ", school='" + school + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Classroom classroom = (Classroom) o;
        return classNo == classroom.classNo &&
                Objects.equals(className, classroom.className);
    }

    @Override
    public int hashCode() {
        return Objects.hash(className, classNo);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
