package com.spring.FlightInformationSystem;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(description = " Flight Information System", title = "My API", version = "2.0.2"))
public class ProjectTest implements CommandLineRunner{


 
    public static void main(String[] args) {
        SpringApplication.run(ProjectTest.class, args);
        
    }
    @Override
    public void run(String... args) throws Exception {
       System.out.println("hello");
    }
    
}
