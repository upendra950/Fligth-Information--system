package com.spring.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Tester implements CommandLineRunner{
    
    @Autowired
    Products avg;
    @Autowired
    Categories cat;
    
    public static void main(String[] args) {
        SpringApplication.run(Tester.class,args);
        
        
    }

    @Override
    public void run(String... args) throws Exception {
        
        //avg.displayCatcode();
        avg.prodNameAndCatDesc(30,1500);
        //cat.category();

        
    }
    
}
