package code.sample.webdemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ChildAService {
    private final ApplicationContext applicationContext;
    private final ParentService parentService;

    public void doSomethingByChildA() {
        log.info("ChildAService: doSomethingByChildA()");
        log.info("Application context: {}", applicationContext);
        parentService.doSomethingByParent();
    }
}
