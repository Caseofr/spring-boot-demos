package code.sample.webdemo.dto.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.Map;

public class ObjectMapSerializer extends JsonSerializer<Map<String, Object>> {

    @Override
    public void serialize(Map<String, Object> map, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            gen.writeObjectField(entry.getKey(), entry.getValue() != null ? entry.getValue().toString() : null);
        }
        gen.writeEndObject();
    }
}