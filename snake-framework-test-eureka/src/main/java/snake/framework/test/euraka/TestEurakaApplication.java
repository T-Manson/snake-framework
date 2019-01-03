package snake.framework.test.euraka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author TManson
 */
@SpringBootApplication
@EnableEurekaServer
public class TestEurakaApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestEurakaApplication.class);
    }
}
