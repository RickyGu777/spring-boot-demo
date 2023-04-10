package com.gurenkai.demo.infrastructure.config.enumconvert;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author gu_renkai
 * @date 2023/2/10 16:42
 */

@Component
public class JacksonConfig implements SmartInitializingSingleton {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void afterSingletonsInstantiated() {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Enum.class, new EnumDeserializer());
        objectMapper.registerModule(simpleModule);
    }
}