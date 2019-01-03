package snake.framework.test.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author TManson
 */
@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class TestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApiApplication.class);
    }
}
