package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonService personService= (PersonService) cxt.getBean("personService");
        personService.print();
    }
}
