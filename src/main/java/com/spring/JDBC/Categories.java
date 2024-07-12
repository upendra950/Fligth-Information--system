package com.spring.JDBC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
@Component
public class Categories {
    @Autowired
    JdbcTemplate jdbctemplate;
   
    public void category(){


        jdbctemplate.execute("alter table categories add category varchar (255)");
      //  System.out.println("no of rows added is: "+b);
    
    }
    
}
