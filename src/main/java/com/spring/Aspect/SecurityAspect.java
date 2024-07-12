package com.spring.Aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspect {

@Pointcut("execution (* com.spring.Aspect.Payment.*(..))")
    public void m1(){

    }

        @Before("m1()") //joinpoint
         public void begin(){
            System.out.println("begin transaction");
         }

         @Around("m1()")
         public void Aroundprocess(ProceedingJoinPoint jpj) throws Throwable{
            System.out.println("hello");
            jpj.proceed();
            System.out.println("completed");
            
            
            
         }
}
