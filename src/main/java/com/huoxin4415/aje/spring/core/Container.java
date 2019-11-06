package com.huoxin4415.aje.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Container {

    public static void main(String[] args) {
        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        // retrieve configured instance
        Service service = context.getBean("service", Service.class);
        
        // use configured instance
        service.hello();
    }

}