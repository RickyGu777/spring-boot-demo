package com.gurenkai.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Long roleId;

    private String roleName;

    private String roleKey;

    private int dataScope;

}
