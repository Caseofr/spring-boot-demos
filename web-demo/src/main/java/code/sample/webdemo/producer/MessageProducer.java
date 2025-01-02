package code.sample.webdemo.producer;

import code.sample.webdemo.dto.ComplexRequestDto;
import code.sample.webdemo.service.AsyncService;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.experimental.SuperBuilder;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class MessageProducer {
    @Value("${root.some-value}")
    private String someValue;

    private final ObjectMapper objectMapper;
    private final AsyncService asyncService;

    public void sendMessage() throws JsonProcessingException {
        log.info("Sending message");
        log.info("objectMapper = {}, asyncService = {}", objectMapper, asyncService);

        ComplexRequestDto dto = ComplexRequestDto.builder().name("Chan Tai Man").age(19).build();
        asyncService.doSomethingAsync(objectMapper.writeValueAsString(dto));
    }

    public static void main(String[] args) throws JsonProcessingException {
        Parent parent =
                Child.builder()
                        .parentA("parent-a")
                        .parentB("parent-b")
                        .childA("child-a")
                        .childB("child-b")
                        .build();

        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println(objectMapper.writeValueAsString(parent));
    }

    @Data
    @SuperBuilder
    static class Parent {
        private String parentA;
        private String parentB;
    }

    @EqualsAndHashCode(callSuper = true)
    @Data
    @SuperBuilder
    static class Child extends Parent {
        private String childA;
        private String childB;
    }
}
