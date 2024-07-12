package com.spring.SpringRest.RestController;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.SpringRest.Entity.Categories2;
import com.spring.SpringRest.Repo.Categories2Repo;


@RestController
@RequestMapping("/categories")
public class Categories2Controller {
    @Autowired
    Categories2Repo categories2Repo;
    @GetMapping
    public List<Categories2> getCategories2(){
         return categories2Repo.findAll();
    }
    @PostMapping("/add")
    public void addCategories2(@RequestBody Categories2 categories2){
        categories2Repo.save(categories2);
    }
    @GetMapping("/n")
    public String get(){
        return "hi";
    }
    @PutMapping("/update/{id}")
    public Categories2 updateCategories2(@PathVariable("id") String id,@RequestBody Categories2 categories2){
        Categories2 result_id=categories2Repo.findById(id).get();
        //result_id.setCatCode(categories2.getCatCode());
        result_id.setCatDesc(categories2.getCatDesc());
        System.out.println(categories2.toString());
        return categories2Repo.save(result_id);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteCategories2(@PathVariable("id") String id){
        categories2Repo.deleteById(id);

    }
    
}
