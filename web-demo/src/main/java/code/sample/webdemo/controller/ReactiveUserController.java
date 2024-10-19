package code.sample.webdemo.controller;

import code.sample.webdemo.dto.User;
import code.sample.webdemo.service.DelayedService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("/reactive")
@RestController
@RequiredArgsConstructor
public class ReactiveUserController {
    final DelayedService delayedService;
    int count = 0;

    @GetMapping("/users/{id}")
    public Mono<User> getUserById(@PathVariable Long id) {
        // Non-blocking async call, returns a Mono that emits a single user
        log.info("Webflux call count = {}, thread = {}", ++count, Thread.currentThread().getName());
        return delayedService
                .findUserByIdNio(id)
                .doOnNext(response -> log.info("Sending non-blocking response."));
    }
}
