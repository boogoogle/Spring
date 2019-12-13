package com.booo.spring.config;

import com.booo.spring.filter.MyFilter;
import com.booo.spring.listener.MyListener;
import com.booo.spring.servlet.Myservlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.ServletContextListener;
import java.util.Arrays;

@Configuration
public class MyServerConfig {

    // 注册三大组件
    @Bean
    public ServletRegistrationBean myServlet(){
        ServletRegistrationBean<Myservlet> myservletServletRegistrationBean = new ServletRegistrationBean<>(new Myservlet(), "/myServlet");
        return  myservletServletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean myFilter(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello", "/myServlet")); // 需要转换成集合
        return filterFilterRegistrationBean;
    }

    @Bean
    public ServletListenerRegistrationBean myListener(){
        ServletListenerRegistrationBean<MyListener> registrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return registrationBean;
    }






    // 配置嵌入式的Servlet容器
}
