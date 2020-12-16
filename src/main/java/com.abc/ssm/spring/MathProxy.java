package com.abc.ssm.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//静态代理模式
@Component("mathProxy")
public class MathProxy implements IMath{
    @Autowired
    private IMath math;

    public void before(){
        System.out.println("校验");
        System.out.println("前置日志");
    }

    public void after(){
        System.out.println("后置日志");
    }


    @Override
    public void add() {
        before();
        math.add();
        after();
    }

    @Override
    public void sub() {
        before();
        math.sub();
        after();
    }

    @Override
    public void mul() {
        before();
        math.mul();
        after();
    }

    @Override
    public void div() {
        before();
        math.div();
        after();
    }
}