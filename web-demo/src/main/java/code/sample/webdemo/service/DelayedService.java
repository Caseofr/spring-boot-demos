package code.sample.webdemo.service;

import code.sample.webdemo.dto.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
@Slf4j
@RequiredArgsConstructor
public class DelayedService {
    public User findUserById(Long id) {
        // Simulate fetching from a database
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return User.builder().id(id).build();
    }

    // Non-blocking method for use in the Spring Reactive Web controller
    public Mono<User> findUserByIdNio(Long id) {
        log.info("Starting non-blocking operation...");
        return Mono.delay(Duration.ofSeconds(5))
            .doOnNext(i -> log.info("Non-blocking operation finished."))
            .map(i -> User.builder().id(id).name("John Doe").build());
    }
}
