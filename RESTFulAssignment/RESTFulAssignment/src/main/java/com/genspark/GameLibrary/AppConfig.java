package com.genspark.GameLibrary;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class AppConfig {

    @Bean
//    @Scope("singleton") or
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    @Scope("prototype") or
    @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public AtomicInteger createCounter() {
        return new AtomicInteger();
    }

}
