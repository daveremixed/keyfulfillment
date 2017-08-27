package com.gonzobeans.keyfulfillment.config;


import com.gonzobeans.keyfulfillment.converters.RdbToAppConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;

import java.util.HashSet;
import java.util.Set;

@Configuration
public class ConversionConfig {

    @Bean
    public ConversionService getConversionService() {
        ConversionServiceFactoryBean factoryBean = new ConversionServiceFactoryBean();
        factoryBean.setConverters(getConverters());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    private Set<Converter> getConverters() {
        Set<Converter> converters = new HashSet<>();
        converters.add(new RdbToAppConverter());
        return converters;
    }
}
