package code.sample.webdemo.controller;

import code.sample.webdemo.dto.User;
import code.sample.webdemo.service.CommonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/user")
@RestController
@RequiredArgsConstructor
public class UserController {
    final CommonService commonService;

    @GetMapping("/user-concat")
    public ResponseEntity<String> getUserConcatTest() {
        log.info("Received request for getUserConcatTest()");

        User user = User.builder().build();
        return ResponseEntity.ok(commonService.concatUserAttributes(user));
    }


}
