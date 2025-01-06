package code.sample.webdemo.controller;

import code.sample.webdemo.dto.User;
import code.sample.webdemo.service.DelayedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequestMapping("/wc/")
@RestController
@RequiredArgsConstructor
public class WebClientTestUserController {
    final DelayedService delayedService;
    final AtomicInteger countAtomic = new AtomicInteger(0);
    int count = 0;


    // NIO
    @GetMapping("/reactive/users/{id}")
    public Mono<User> getUserByIdNio(@PathVariable Long id) {
        // Non-blocking async call, returns a Mono that emits a single user
        log.info("Webflux call count = {}, thread = {}", ++count, Thread.currentThread().getName());
        return delayedService
            .findUserByIdNio(id)
            .doOnNext(response -> log.info("Sending non-blocking response."));
    }


    // Blocking
    @GetMapping("/web/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Simulating a blocking database call or service call
        log.info("Web call count = {}, thread = {}", countAtomic.incrementAndGet(), Thread.currentThread().getName());
        User user = delayedService.findUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    public static void main(String[] args) {
        WebClient.create()
            .get()
            .uri("http://localhost:8080/wc/web/users/1")
            .retrieve()
            .onStatus(HttpStatusCode::is2xxSuccessful,
                cr ->
                    cr.bodyToMono(String.class)
                        .flatMap(s -> {
                            System.out.println("do something in onStatus(), body = " + s);
                            return Mono.empty();
                        })
            )
            .toEntity(String.class)
            .timeout(Duration.ofSeconds(10))
            .doOnNext(System.out::println)
            .onErrorResume(e -> {
                System.out.println("onErrorResume(), e = " + e.getMessage());
                return Mono.empty();
            })
            .block();

    }

}
