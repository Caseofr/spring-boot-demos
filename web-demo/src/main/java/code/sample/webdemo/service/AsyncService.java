package code.sample.webdemo.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AsyncService {
    @Async
    public void doSomethingAsync(String someParameter) {
        log.info("Starting asynchronous task..., someParameter = {}", someParameter);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        log.info("Asynchronous task finished.");
    }
}
