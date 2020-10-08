package com.perrinsjason.demo.rsocketprotogreetingservice.controller;


import com.perrinsjason.demo.rsocketprotogreetingservice.service.DefaultGreetingService;
import com.proto.example.GreetingRequest;
import com.proto.example.GreetingResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class RSocketGreetingsController {

    private final DefaultGreetingService defaultGreetingService;

    @MessageMapping("greeting")
    public Mono<GreetingResponse> greeting(GreetingRequest request){
            return defaultGreetingService.greeting(request,null);
    }

    @MessageMapping("random.greetings")
    public Flux<GreetingResponse> randomGreetingsGenerator(){
        return defaultGreetingService.randomGreetings(null,null);
    }

}
