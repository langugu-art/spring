package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main   {
    public static void main(String[] args) {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object zhao=cxt.getBean("zhao");
//        System.out.println(zhao);
//        Object qian=cxt.getBean("qian");
//        System.out.println(qian);

//        Person zhao= (Person) cxt.getBean("zhao");
//        Phone phone=zhao.getPhone();
//        System.out.println(zhao.getpName());
//        System.out.println(phone);

        PersonService personService= (PersonService) cxt.getBean("personService");
        personService.print();
    }
}
