package com.example.demo.controllers;

import com.example.demo.model.Greeting;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {  
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/greeting")  
    public Greeting greeting(
        @RequestParam(value = "name", defaultValue = "World") String name) {
        
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
      //incrementAndGet serve para mocar o counter, isto faz com que altere o valor de id sem o uso do BD!
    }
}