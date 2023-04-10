package com.gurenkai.demo.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.gurenkai.demo.infrastructure.persistence.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<User> {
}
