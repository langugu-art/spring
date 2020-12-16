package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.common.SpringIOC;
import com.abc.dao.entity.User;
import com.abc.service.iservice.IUserService;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceImplTest {
    IUserService userService;
    private static Logger log=Logger.getLogger(UserServiceImplTest.class);
    @Before
    public  void setUp(){
        userService = (IUserService) SpringIOC.getSpringIOC().getBean("empService");
    }

    @Test
    public void userExist() {
        Res res = userService.userExist("root");
        log.info("************************"+res);
    }

    @Test
    public void login() {
        User user=new User("root","root");
        System.out.println(userService.login(user));
    }
}