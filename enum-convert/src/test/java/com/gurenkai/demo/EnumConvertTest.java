package com.gurenkai.demo;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.lenient;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EnumConvertTest {


    @Test
    public void testEnumConvert() {

    }

}
