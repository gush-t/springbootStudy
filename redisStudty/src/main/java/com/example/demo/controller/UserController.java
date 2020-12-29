package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping(value = "list")
    public List<User> userList() {
        return userService.findAll();
    }

    @ResponseBody
    @DeleteMapping
    public void deleteUserById(@RequestParam(required = true) String id) {
        userService.deleteById(id);
    }

    @ResponseBody
    @PutMapping
    @PostMapping
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }
}
