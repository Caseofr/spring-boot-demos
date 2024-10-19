package code.sample.persistencedemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("code.sample.persistencedemo.repository")
@MapperScan("code.sample.persistencedemo.mapper")
public class PersistenceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(PersistenceDemoApplication.class, args);
    }
}
