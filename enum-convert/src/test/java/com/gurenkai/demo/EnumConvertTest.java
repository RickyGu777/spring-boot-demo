package com.gurenkai.demo;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.gurenkai.demo.infrastructure.enums.VipLevel;
import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EnumConvertTest {

    private final String URL = "http://localhost:8080/user";

    @Test
    public void testEnumConvert() {
        String body = """
                {
                    "account": "admin",
                    "pwd": "111111",
                    "name": "管理员",
                    "vip": 2
                }""";
        String id = HttpUtil.post(URL, body);
        String userJson = HttpUtil.get(URL + "/" + id);
        assert (JSONUtil.parseObj(userJson).getInt("vip") == VipLevel.WHITE_GOLD.getLevel());
        HttpUtil.post(URL + "/delete/" + id, "{}");
    }

}
