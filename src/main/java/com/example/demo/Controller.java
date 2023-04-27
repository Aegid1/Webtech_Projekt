package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/")
	public String index(){ return "Hello World!"; }
    
    @RequestMapping(path="/test/mohamed/aegid/")
    public String queryParameter(@RequestParam("user") String name){

        return name;
    
    }   
    

}