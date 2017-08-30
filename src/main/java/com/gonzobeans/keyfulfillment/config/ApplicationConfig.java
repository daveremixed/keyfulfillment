package com.gonzobeans.keyfulfillment.config;

import com.gonzobeans.keyfulfillment.dao.Persistence;
import com.gonzobeans.keyfulfillment.dao.PostGresPersistenceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public Persistence persistence() {
        return new PostGresPersistenceImpl();
    }
}
