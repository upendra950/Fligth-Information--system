package com.spring.JPA.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.spring.JPA.Entities.Products1;
import com.spring.JPA.Entities.Sales1;
import com.spring.JPA.Repo.Products1Repo;
import com.spring.JPA.Repo.Sales1Repo;
@Component
public class Sales1Service {
    @Autowired
    Sales1Repo sales1Repo;
    @Autowired
    Products1Repo products1Repo;
    public void getAllByProductId(int prodId){
        Products1 p=products1Repo.findById(prodId).get();
        List<Sales1> sales=sales1Repo.findAllByProduct(p);
        for (Sales1 sales1 : sales) {
            System.out.println(sales1);
            
        }
        
    
    }
    public void getAllByQtyBetweenGivenRange(int min,int max){
        List<Sales1> sales=sales1Repo.findAllByQtyBetween(min,max);
        for (Sales1 sales1 : sales) {
            System.out.println(sales1);
            
        }

    }

    public void getAllByProductPriceLessThanPrice(double price){
        
        List<Sales1> sales=sales1Repo.findAllByProductPriceLessThan(price);
        for (Sales1 sales1 : sales) {
            System.out.println(sales1);
        }
    }


    public void  getByQtyAscendingOrder(){
        List<Sales1> sales=sales1Repo.findAllByOrderByQtyAsc();
        for (Sales1 sales1: sales) {
            System.out.println(sales1);
            
        }
        
        
    }
    public void getAllByPage(int pageNo,int pageSize){
        PageRequest pr=PageRequest.of(pageNo,pageSize);
        Page<Sales1> pages=sales1Repo.findAll(pr);
        List<Sales1> pageData=pages.getContent();
        for (Sales1 data : pageData) {
            System.out.println(data);
            
        }
        
        


    }
    

    
}
