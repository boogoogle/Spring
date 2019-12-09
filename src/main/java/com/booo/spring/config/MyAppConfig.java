package com.booo.spring.config;

import com.booo.spring.controller.SignupController;
import com.booo.spring.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 指明当前类是配置类,用来代替之前的Spring配置文件
@Configuration
public class MyAppConfig {

    // 将方法的返回值添加到绒里中,容器中这个组件默认的id就是方法名
    @Bean
    public HelloService helloService(){
        System.out.println("@Bean给容器中添加组件HelloService");
        return new HelloService();
    }
}
