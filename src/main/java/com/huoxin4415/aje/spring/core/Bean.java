package com.huoxin4415.aje.spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bean {

    public static void main(String[] args) {
        // create and configure beans
        ApplicationContext context = new ClassPathXmlApplicationContext("services.xml");

        // retrieve configured instance
        Service service = context.getBean("service", Service.class);
        Service serviceByStaticFactory = context.getBean("serviceByStaticFactory", Service.class);
        Service serviceByBean = context.getBean("serviceByBean", Service.class);
        
        // use configured instance
        service.hello();
        serviceByStaticFactory.hello();
        serviceByBean.hello();

        // Single vs Prototype
        Service singleService = context.getBean("service", Service.class);
        Service prototypeService = context.getBean("prototypeService", Service.class);
        System.out.println(service == singleService);
        System.out.println(service == prototypeService);

        Service autowireService = context.getBean("autowireService", Service.class);
        System.out.println(autowireService.getUser());
        System.out.println(service.getUser());
    }
    
}