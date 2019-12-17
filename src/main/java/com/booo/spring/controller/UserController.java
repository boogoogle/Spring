package com.booo.spring.controller;

import com.booo.spring.bean.Person;
import com.booo.spring.bean.User;
import com.booo.spring.dao.UserDao;
import com.booo.spring.mapper.PersonMapper;
import com.booo.spring.mapper.UserMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    // 自动装配
    @Autowired
    UserDao userDao;

    @Autowired
    UserMapper userMapper;

    @Autowired
    PersonMapper personMapper;

    // 查询所欲员工返回列表页面
    @GetMapping("/users")
    public Collection list(){
//        Collection<User> allUsers = userDao.getAll();
        Collection<User> allUsers = userMapper.getAllUsers();
        return allUsers;
    }

    // 添加用户
    // SpringMVC自动将请求参数和入参的属性进行一一绑定, 要求请求参数名和JavaBean的入参属性一致
    @PostMapping("/user")
    public User addUser(User user){
//        return "redirect: /xxx"; // 重定向

        System.out.println("保存的员工信息" + user);
//        userDao.save(user);        return userDao.getAll();
        userMapper.insertUser(user);
        return user;
    }

    // 查询单个用户
    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Integer id) {
        User user = userMapper.getUserByI(id);
        return user;
    }

    @PostMapping("/person")
    public Person addPerson(Person person){

        System.out.println("保存的员工信息" + person);
        personMapper.insertPerson(person);
        return person;
    }




}
