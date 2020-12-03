package com.example.demo.Entity;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "teacher")
@Entity
public class Teacher  extends BaseEntity {

    @Column(name = "`teacherAge`")
    private String teacherAge;
    @Column(name = "`classKind`")
    private String classKind;

    public Teacher() {
    }

    public Teacher(Integer id, String strName) {
        super(id, strName);
    }

    public String getTeacherAge() {
        return teacherAge;
    }

    public void setTeacherAge(String teacherAge) {
        this.teacherAge = teacherAge;
    }

    public String getClassKind() {
        return classKind;
    }

    public void setClassKind(String classKind) {
        this.classKind = classKind;
    }
}
