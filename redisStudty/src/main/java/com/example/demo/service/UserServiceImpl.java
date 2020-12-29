package com.example.demo.service;

import com.example.demo.dao.UserDao;
import com.example.demo.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Cacheable
    public User findById(String id) {
        return userDao.findById(id).orElse(new User("1", "Bob"));
    }

    @Override
    @Cacheable
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    @CacheEvict
    public void deleteById(String id) {
        userDao.deleteById(id);
    }

    @Override
    @CachePut
    public void save(User user) {
        userDao.save(user);
    }
}
