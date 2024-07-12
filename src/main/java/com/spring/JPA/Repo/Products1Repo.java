package com.spring.JPA.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.JPA.Entities.Products1;

public interface  Products1Repo extends JpaRepository<Products1,Integer> {
   //public List<Products1> findByPrice(double price);
  
    
}
