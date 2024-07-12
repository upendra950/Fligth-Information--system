package com.spring.JPA.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.JPA.Repo.Products1Repo;
@Component
public class Products1Service {
    @Autowired
    Products1Repo products1Repo;

    
}
