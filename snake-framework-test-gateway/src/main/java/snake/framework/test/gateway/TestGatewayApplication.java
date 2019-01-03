package snake.framework.test.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulServer;

/**
 * @author TManson
 */
@SpringBootApplication
@EnableEurekaClient
@EnableZuulServer
public class TestGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestGatewayApplication.class);
    }
}
