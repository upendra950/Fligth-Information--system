package com.spring.JPA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.spring.JPA.Repo.Sales1Repo;
import com.spring.JPA.Service.Products1Service;
import com.spring.JPA.Service.Sales1Service;

@SpringBootApplication
public class Test1 implements CommandLineRunner {
    @Autowired 
    Products1Service products1Service;
   @Autowired
   Sales1Service sales1Service;
    @Autowired
    Sales1Repo sales1Repo;

    
    public static void main(String args[]){
        SpringApplication.run(Test1.class,args);
    }

    @Override
    public void run(String... args) throws Exception {

    //Products1 p= new Products1("Watch", 15000, 8, "nice", 7.4);
    //Sales1 s=new Sales1("C456", LocalDate.of(2024,02,26), 3, "Done",p);
    //   sales1Service.getAllByProductId(2);
    //   sales1Service.getAllByQtyBetweenGivenRange(4,12);
    //   sales1Service.getAllByProductPriceLessThanPrice(28000);
    //   sales1Service.getByQtyAscendingOrder();
    sales1Service.getAllByPage(0,2);
  // sales1Repo.save(s);
        



        
        


        
       

    }

    
}
