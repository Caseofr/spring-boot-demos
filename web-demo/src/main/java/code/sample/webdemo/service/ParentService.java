package code.sample.webdemo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ParentService {
    // nothing to do
    private final ObjectMapper objectMapper;

    public void doSomethingByParent() {
        log.info("ParentService: doSomethingByParent()");
        log.info("objectMapper = {}", objectMapper);
    }
}
