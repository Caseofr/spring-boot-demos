package code.sample.webdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebDemoApplication.class, args);
    }
//    public static void main(String[] args) throws Exception {
//        String str = "some shit to be masked, then log";
//
//        ObjectMapper om = new ObjectMapper();
//        System.out.println(om.writeValueAsString(str));
//    }
}
