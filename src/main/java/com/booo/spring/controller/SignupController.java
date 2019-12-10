package com.booo.spring.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody // 这个类的所有方法都直接写给浏览器(对象会自动转成JSON)
//@Controller
@RestController // 相当于上面两个注解的合体作用, 同样会把当前方法作为一个bean加入到容器中
public class SignupController {

    public SignupController() {
    }
    // 用@value获取配置文件中的值
    @Value ("${person.last-name}")
    private String name;

    //    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "hello " + name;
    }
}
