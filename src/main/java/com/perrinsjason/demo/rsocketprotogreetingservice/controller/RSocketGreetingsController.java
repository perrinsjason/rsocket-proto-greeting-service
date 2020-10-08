package com.perrinsjason.demo.rsocketprotogreetingservice.controller;


import com.perrinsjason.demo.rsocketprotogreetingservice.service.DefaultGreetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class RSocketGreetingsController {

    private final DefaultGreetingService defaultGreetingService;

    @MessageMapping("string")
    public String StringGreeting(String name){
        return defaultGreetingService.StringGreeting(name);
    }

    @MessageMapping("mono")
    public Mono<String> MonoGreeting(String name) {
        return defaultGreetingService.MonoGreeting(name);
    }

    @MessageMapping("flux")
    public Flux<String> randomGreetingsGenerator(){
        return defaultGreetingService.randomGreetingsGenerator();
    }

}
