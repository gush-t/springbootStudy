package com.example.demo.entity;

import javassist.SerialVersionUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Table
@Entity
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column
    private String id;

    @Column
    private String userName;

    public User() {
    }

    public User(String id, String userName) {
        this.id = id;
        this.userName = userName;
    }



    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", userName='" + userName + '\'' +
                '}';
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Id
    public String getId() {
        return id;
    }
}
