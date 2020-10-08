package com.perrinsjason.demo.rsocketprotogreetingservice.service;

import com.proto.example.GreetingRequest;
import com.proto.example.GreetingResponse;
import com.proto.example.GreetingService;
import io.netty.buffer.ByteBuf;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
@Service
public class DefaultGreetingService implements GreetingService {

      private String randomNameGenerator(){
        var names = Arrays.asList("Jason","Nicola","Sophie","Marianne","Bob","John");
        return names.get(ThreadLocalRandom.current().nextInt(0,names.size()-1));
    }

    @Override
    public Mono<GreetingResponse> greeting(GreetingRequest greetingRequest, ByteBuf byteBuf) {
        log.info("greeting request: {} bugger {}",greetingRequest);
        return Mono.just(GreetingResponse.newBuilder().setName("Hello "+greetingRequest.getName()).build()).log();
    }

    @Override
    public Flux<GreetingResponse> randomGreetings(GreetingRequest greetingRequest, ByteBuf byteBuf) {
        log.info("randomGreetings request");
        return Flux.interval(Duration.ofSeconds(5)).map(response -> GreetingResponse.newBuilder().setName("Hello " + randomNameGenerator()).build()).log();
    }
}
