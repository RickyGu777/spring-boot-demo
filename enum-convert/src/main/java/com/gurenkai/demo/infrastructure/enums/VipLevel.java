package com.gurenkai.demo.infrastructure.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum VipLevel {
    GOLD(1, "黄金会员"),
    WHITE_GOLD(2, "白金会员"),
    BLACK_GOLD(3, "黑金会员"),
    DIAMOND(3, "钻石会员"),
    ;
    @EnumValue
    private final int level;

    private final String name;

}
