package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main_01 {
    public static void main(String[] args) {
        ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
        IMath math= (IMath) cxt.getBean("mathProxy");
        math.add();
        math.sub();
        math.mul();
        math.div();
    }
}
