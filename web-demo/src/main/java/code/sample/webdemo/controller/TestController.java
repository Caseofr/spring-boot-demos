package code.sample.webdemo.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/test")
@RequiredArgsConstructor
public class TestController {

    @RequestMapping("/hello")
    public String helloWorld() throws InterruptedException {
        log.info("Received a request for hello world");
        Thread.sleep(5000);
        return "Hello, World!";
    }
}
