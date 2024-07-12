package com.spring.example;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class Controller {
    @GetMapping("/")
    public void msg(){
        System.out.println("hello ");

    }
    
}
