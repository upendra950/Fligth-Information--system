package com.spring.SpringRest.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringRest.Entity.Products2;
import com.spring.SpringRest.Repo.Products2Repo;

@RestController
@RequestMapping("/product")
public class Products2Controller {
    @Autowired
    Products2Repo products2Repo;

    @GetMapping()
    public String details(){
        String res="good";
        return res;
        
    }
    @GetMapping("/get")
    public List<Products2> getProducts2(){
        return products2Repo.findAll();
       
    }
    @PostMapping("/add")
    public void addProducts2(@RequestBody Products2 products2){
        products2Repo.save(products2);
        
    }
    
}
