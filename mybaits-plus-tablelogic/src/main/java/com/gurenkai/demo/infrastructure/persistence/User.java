package com.gurenkai.demo.infrastructure.persistence;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"account", "deleted"})
@TableName("demo_mp_tablelogic_user")
public class User {

    @TableId(type = IdType.AUTO)
    private Long id;
    private String account;
    private String pwd;
    private String name;
    private boolean deleted;
}
