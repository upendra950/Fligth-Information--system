package com.spring.Aspect;

import org.springframework.stereotype.Component;

@Component
public class Payment {
    public void payComponent(){
        System.out.println("hello welcome, select your payment method");
    }
    public boolean validateCC(String c){
        System.out.println("your account is validating,please wait ");
        if (c.length()>0){
            return true;
        }
        else{return false;}

    }
    public void process(){
        System.out.println("processing , please wait");
    }
    
}

    