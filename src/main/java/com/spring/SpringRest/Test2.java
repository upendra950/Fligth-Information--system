package com.spring.SpringRest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.SpringRest.RestController.Categories2Controller;
import com.spring.SpringRest.RestController.Products2Controller;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
@SpringBootApplication

@OpenAPIDefinition(info = @Info(description = " documentation", title = "My API", version = "2.0.2"))
public class Test2 implements CommandLineRunner {
    @Autowired
    Categories2Controller categories2Controller;
    @Autowired
    Products2Controller products2Controller;
    public static void main(String[] args) {
        SpringApplication.run(Test2.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
      
    }  
}
