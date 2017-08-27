package com.gonzobeans.keyfulfillment;

import com.gonzobeans.keyfulfillment.config.ApplicationConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ApplicationConfig.class);
        application.run(args);
    }
}
