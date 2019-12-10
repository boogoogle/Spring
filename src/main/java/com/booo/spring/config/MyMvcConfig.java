package com.booo.spring.config;

import com.booo.spring.component.LoginHandlerInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/success").setViewName("success");
    }


    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // SpringBoot已经做好了静态资源映射,所以不需要对js/css等静态资源做处理
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")  // 所有路径都拦截
//                .excludePathPatterns("/index.html", "/", "/user/login"); // 排除部分路径
    }
}
