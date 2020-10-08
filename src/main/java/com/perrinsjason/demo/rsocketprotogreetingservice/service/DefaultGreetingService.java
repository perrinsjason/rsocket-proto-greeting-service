package com.perrinsjason.demo.rsocketprotogreetingservice.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class DefaultGreetingService {

    public String StringGreeting(String name){
        return "Hello "+name;
    }

    public Mono<String> MonoGreeting(String mono) {
        return Mono.just(StringGreeting(mono));
    }

    public Flux<String> randomGreetingsGenerator(){
        return  Flux.interval(Duration.ofSeconds(5)).map(name -> randomNameGenerator()).log();
    }

    private String randomNameGenerator(){
        var names = Arrays.asList("Jason","Nicola","Sophie","Marianne","Bob","John");
        return names.get(ThreadLocalRandom.current().nextInt(0,names.size()-1));
    }
}
