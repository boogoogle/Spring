package com.booo.spring.controller;

import com.booo.spring.bean.User;
import com.booo.spring.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

//@ResponseBody // 这个类的所有方法都直接写给浏览器(对象会自动转成JSON)
//@Controller
@RestController // 相当于上面两个注解的合体作用, 同样会把当前方法作为一个bean加入到容器中
public class SignupController {


    @Autowired // 自动装配
    JdbcTemplate jdbcTemplate;

    @Autowired
    UserMapper userMapper;


    // 用@value获取配置文件中的值
    @Value ("${person.last-name}")
    private String name;

    //    @ResponseBody
    @RequestMapping("/add")
    public Integer hello(){
        User user =  new User("lisi", "1234");
        int i = userMapper.insertUser(user);
        return i;
    }

    @GetMapping("/user/:id")
    public String getUser(){
//        User user = userMapper.getUserByI()
        return "good";
    }


    @GetMapping("/query")
    public Map<String, Object> map() {
//        String sql = "insert into users(id) values(1111113)";
//        int b = jdbcTemplate.update(sql);
        String sql = "select * from department";
        List<Map<String, Object>> list = jdbcTemplate.queryForList(sql);

        return list.get(1);
    }
}
