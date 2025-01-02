package code.sample.webdemo.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

import org.junit.jupiter.api.Test;

import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

@Slf4j
class ComplexRequestDtoTest {

    @Test
    void test() throws JsonProcessingException {
        PodamFactory factory = new PodamFactoryImpl();
        ComplexRequestDto originalDto = factory.manufacturePojoWithFullData(ComplexRequestDto.class);
        log.info("originalPojo = {}", originalDto);

        ObjectMapper om = new ObjectMapper();
        String serialized = om.writeValueAsString(originalDto);

        log.info(serialized);

        ComplexRequestDto deserializedDto = om.readValue(serialized, ComplexRequestDto.class);

//        //        assertEquals(originalDto, deserializedDto);
        log.info("dto equals? = {}", originalDto.equals(deserializedDto));
//
        String reSerialized = om.writeValueAsString(deserializedDto);
//
        assertEquals(serialized, reSerialized);
//        //        System.out.println(serialized.equals(reSerialized));
    }
}
