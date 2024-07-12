package com.spring.Aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class TestAspect implements CommandLineRunner{
    @Autowired
     Payment se;
    


    public static void main(String args[]){
        SpringApplication.run(TestAspect.class, args);

 
    }

    @Override
    public void run(String... args) throws Exception {
        se.payComponent();
        


        
    }
    
}
