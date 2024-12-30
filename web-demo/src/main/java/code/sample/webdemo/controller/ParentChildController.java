package code.sample.webdemo.controller;

import code.sample.webdemo.dto.User;
import code.sample.webdemo.service.ChildAService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/parent-child")
@RestController
@RequiredArgsConstructor
public class ParentChildController {
    final ChildAService childAService;

    @GetMapping("/")
    public ResponseEntity<User> getUserById() {
        childAService.doSomethingByChildA();
        return ResponseEntity.ok().build();
    }
}
