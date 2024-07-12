package com.spring.QuoteEx;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
@Primary
@Component
public class Friendship  implements Quotes{

    @Override
    public List<String> getQuotes() {
       return Arrays.asList("Together, we're unstoppable"," Three peas in a pod, forever and always.","Life is better with my trio by my side "); 
      
    }
    
}
