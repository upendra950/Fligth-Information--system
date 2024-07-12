package com.spring.JPA.Repo;


import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.JPA.Entities.Products1;
import com.spring.JPA.Entities.Sales1;

public interface Sales1Repo extends JpaRepository<Sales1,Integer>{
   public List<Sales1> findAllByProduct(Products1 products1 );
   public List<Sales1> findAllByQtyBetween(int min,int max);
   public List<Sales1> findAllByProductPriceLessThan(double  price);
   public List<Sales1> findAllByOrderByQtyAsc();
   
    
}
