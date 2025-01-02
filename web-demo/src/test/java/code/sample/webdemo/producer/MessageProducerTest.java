package code.sample.webdemo.producer;

import code.sample.webdemo.service.AsyncService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.*;
class MessageProducerTest {
    @Mock
    ObjectMapper objectMapper;
    @Mock
    AsyncService asyncService;
    @InjectMocks
    MessageProducer messageProducer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testSendMessage() throws JsonProcessingException {
        when(objectMapper.writeValueAsString(any(Object.class))).thenReturn("writeValueAsStringResponse");

        messageProducer.sendMessage();
        verify(asyncService).doSomethingAsync(anyString());
    }
}

//Generated with love by TestMe :) Please raise issues & feature requests at: https://weirddev.com/forum#!/testme