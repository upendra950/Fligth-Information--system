package com.spring.QuoteEx;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
@SpringBootApplication
public class TestQuotes implements CommandLineRunner{
    
    @Autowired
    DisplayQuotes dsp;
    @Autowired
    PrintQuotes pq;
    public static void main(String[] args) {

        SpringApplication.run(TestQuotes.class,args);
        
    }
    @PostConstruct
    public void sample(){
        System.out.println("hello welcome to you");
    }

    @Override
    public void run(String... args) throws Exception {
        pq.frndQuot();
    }
    
}
