package com.booo.spring;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@MapperScan(value = "com.booo.spring.mapper")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public ViewResolver myViewResolver(){
		return new MyViewResolver();
	}


	private static class MyViewResolver implements ViewResolver{
		@Override
		public View resolveViewName(String s, Locale locale) throws Exception {
			return null;
		}
	}

}
