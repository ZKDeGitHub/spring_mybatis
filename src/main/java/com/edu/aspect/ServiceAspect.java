package com.edu.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author: zk
 * @description: TODO
 * @date: 2023/12/9 13:58
 * @version: 1.0
 */
@Component//声明是一个Bean
@Aspect//声明是一个切面类
public class ServiceAspect {
    @Pointcut("execution(* com.edu.service..*(..))")
    public void pc() {
    }

    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        System.out.println("前置通知执行了");
    }

}
