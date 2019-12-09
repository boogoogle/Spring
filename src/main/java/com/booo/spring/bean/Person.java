package com.booo.spring.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

@PropertySource(value = {"classpath:/person.properties"})  // 这里的/斜杠路径有时候不能少
@Component  // 通过Component添加到容器中,不然不会生效
@ConfigurationProperties(prefix = "person")
//@Validated // 校验
public class Person {
    @Value("${person.last-name}")  // 通过@Value赋值
    private String lastName;
//    @Value("${person.age}")
    private Integer age;
    private Date birth;
    private Map<String, Object> maps;
    private List<Object> lists;


    @Override
    public String toString() {
        return "Person{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", birth=" + birth +
                ", maps=" + maps +
                ", lists=" + lists +
                '}';
    }
}
