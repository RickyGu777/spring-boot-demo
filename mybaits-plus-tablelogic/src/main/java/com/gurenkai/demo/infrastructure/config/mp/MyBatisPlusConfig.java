package com.gurenkai.demo.infrastructure.config.mp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author gu_renkai
 * @date 2022/12/6 10:57
 */
@Configuration
public class MyBatisPlusConfig {

    @Bean
    public EasySqlInjector easySqlInjector() {
        return new EasySqlInjector();
    }

}
