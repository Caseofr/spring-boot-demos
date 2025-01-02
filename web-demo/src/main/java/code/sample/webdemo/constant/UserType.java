package code.sample.webdemo.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Getter
@RequiredArgsConstructor
@Slf4j
public enum UserType {
    ADMIN("admin"),
    USER("user");

    private final String value;


    public static void main(String[] args) {
        log.info("user type = {}", UserType.USER);
    }
}
