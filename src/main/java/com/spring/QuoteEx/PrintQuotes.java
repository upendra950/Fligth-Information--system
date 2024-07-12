package com.spring.QuoteEx;

// import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class PrintQuotes {
    //@Autowired
    
    Quotes  quotes;

    
    // constructor based dependency injection
    
    @Autowired

    public PrintQuotes(@Qualifier("hardwork") Quotes quotes){
        this.quotes=quotes;
    }
   
   
    @Autowired
    @Qualifier("hardwork")
    public void setQuot(Quotes quotes){
        this.quotes=quotes;
    }

    
   

    public void frndQuot(){
        System.out.println(quotes.getQuotes());
    }
    @PreDestroy
    public void sam(){
        System.out.println("have a nice day ");
    }



}
