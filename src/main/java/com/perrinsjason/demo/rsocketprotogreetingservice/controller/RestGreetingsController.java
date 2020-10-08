package com.perrinsjason.demo.rsocketprotogreetingservice.controller;

import com.perrinsjason.demo.rsocketprotogreetingservice.service.DefaultGreetingService;
import com.proto.example.GreetingRequest;
import com.proto.example.GreetingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greeting/")
@RequiredArgsConstructor
public class RestGreetingsController {

    private final DefaultGreetingService defaultGreetingService;

    @GetMapping(path ="{name}")
    public Mono<String> StringGreeting(@PathVariable("name") String name){

        return defaultGreetingService.greeting(GreetingRequest.newBuilder().setName(name).build(),null).map( response -> response.getName());
    }

    @GetMapping(path = "random")
    public Flux<String> randomGreetingsGenerator(){
        return defaultGreetingService.randomGreetings(null,null).map(response -> response.getName());
    }
}
