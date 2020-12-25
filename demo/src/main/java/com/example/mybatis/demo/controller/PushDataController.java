package com.example.mybatis.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.net.URLDecoder;

@RestController
@RequestMapping("pushData/")
public class PushDataController {

    @PostMapping
    public void receive(HttpServletRequest request, HttpServletResponse response) throws Exception {

    }

}
