package com.spring.JDBC;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class Products {
    @Autowired
    JdbcTemplate jdbctemplate;
    public double average(){
        double b=jdbctemplate.queryForObject("select avg(price) from Products", double.class);
        return b;
        
    }
     public void  displayCatcode(){
     List<Map<String, Object>> op=jdbctemplate.queryForList("select avg(Price),CatCode from Products Group By catcode");
     for(Map<String, Object> o : op){
        System.out.println(o);
     }
 }
     public void category(){
    jdbctemplate.execute("alter table categories add category varchar (255)");
  
}
    public void prodNameAndCatDesc(int length,int price){
        List<Map<String,Object>> ob=jdbctemplate.queryForList("select prodname,catdesc from products p join categories c on c.catcode=p.CatCode where len(prodname)<? and price>?",length,price) ;  
        for(Map<String, Object> o:ob){
            System.out.println(o);
        }
    }
    
}
