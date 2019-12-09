package com.booo.spring;

import com.booo.spring.bean.Person;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
class ApplicationTests {

    @Autowired
	Person person;

    @Autowired
    ApplicationContext ioc;

    @Test
    public void  testHelloService(){
    	boolean b = ioc.containsBean("helloService");
		System.out.println(b);
	}

	@Test
	void contextLoads() {
		System.out.println(person);
	}

}
