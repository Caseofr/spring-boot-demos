package code.sample.webdemo.controller;

import code.sample.webdemo.dto.User;
import code.sample.webdemo.service.CommonService;
import code.sample.webdemo.service.DelayedService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
@RequestMapping("/web")
@RestController
@RequiredArgsConstructor
public class UserController {
    final DelayedService delayedService;
    final CommonService commonService;
    final AtomicInteger count = new AtomicInteger(0);

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        // Simulating a blocking database call or service call
        log.info("Web call count = {}, thread = {}", count.incrementAndGet(), Thread.currentThread().getName());
        User user = delayedService.findUserById(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user-concat")
    public ResponseEntity<String> getUserConcatTest() {
        log.info("Received request for getUserConcatTest()");

        User user = User.builder().build();
        return ResponseEntity.ok(commonService.concatUserAttributes(user));
    }


}
