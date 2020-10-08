package com.perrinsjason.demo.rsocketprotogreetingservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {



    @GetMapping("/")
    public String helloWorld( @Value("${application.version}") String appVersion){
        return "Hello World! "+appVersion;
    }

    @GetMapping("/hi")
    public String hi(){
        return "Hi World! ";
    }

    @GetMapping("")
    public String ServiceUp(){
        return "Hi there, service is up! ";
    }
}
