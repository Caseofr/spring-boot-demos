package code.sample.webdemo.dto;

import code.sample.webdemo.dto.serializer.ObjectMapDeserializer;
import code.sample.webdemo.dto.serializer.ObjectMapSerializer;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ComplexRequestDto {
    private String name;
    private Integer age;
    private Boolean isComplex;
    private List<Contact> contacts;

    @JsonSerialize(using = ObjectMapSerializer.class)
    @JsonProperty
    private Map<String, Object> maps;

    private Map<String, List<File>> fileMaps;

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class Contact {
        private String type;
        private String value;
    }

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode
    public static class File {
        private String name;
        private FileType type;
    }

    enum FileType {
        IMAGE,
        PDF,
        WORD,
        // Add more file types as needed
    }
}
