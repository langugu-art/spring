package com.abc.ssm.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

//@Repository("personDao")
@Repository
public class PersonDao {
    public void print(){
        System.out.println("in persondao");
    }

}
