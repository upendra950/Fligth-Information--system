package com.spring.QuoteEx;

// import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class DisplayQuotes {
    @Autowired
    Quotes  quotes;
    
     
    public   void  getquot(){
        System.out.println(quotes.getQuotes());
   }
    
    
}
