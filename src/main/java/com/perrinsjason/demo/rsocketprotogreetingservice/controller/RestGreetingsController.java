package com.perrinsjason.demo.rsocketprotogreetingservice.controller;

import com.perrinsjason.demo.rsocketprotogreetingservice.service.DefaultGreetingService;
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

    @GetMapping(path ="string/{name}")
    public String StringGreeting(@PathVariable("name") String name){
        return defaultGreetingService.StringGreeting(name);
    }

    @GetMapping(path ="mono/{name}")
    public Mono<String> MonoGreeting(@PathVariable("name")String name) {
        return defaultGreetingService.MonoGreeting(name);
    }

    @GetMapping(path = "flux")
    public Flux<String> randomGreetingsGenerator(){
        return defaultGreetingService.randomGreetingsGenerator();
    }
}
