package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {

    User findById(String id);

    List<User> findAll();

    void deleteById(String id);

    void save(User user);
}
