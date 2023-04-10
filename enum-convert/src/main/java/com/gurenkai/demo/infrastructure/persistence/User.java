package com.gurenkai.demo.infrastructure.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.gurenkai.demo.infrastructure.enums.VipLevel;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@TableName("enum_convert_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String account;
    private String pwd;
    private String name;
    private boolean deleted;
    private VipLevel vip;
}
