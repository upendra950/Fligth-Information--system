package com.spring.QuoteEx;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Lazy
@Scope(scopeName = "prototype")
public class Hardwork implements Quotes {

    @Override
    public List<String> getQuotes() {
        return (List<String>) Arrays.asList("I never dreamt of success"," Success seems to be connected with action"," Successful people are not gifted; they just work hard, then succeed on purpose","Success isn't always about greatness");
        
        
    }
    
}
