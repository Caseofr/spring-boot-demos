package code.sample.webdemo.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
public class User {
    @NonNull
    @Builder.Default
    private Long id = -1L;
    @Builder.Default
    private String name = "on99";
}
