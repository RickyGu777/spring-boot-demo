package com.gurenkai.demo.infrastructure.mapper;

import com.gurenkai.demo.infrastructure.config.mp.EasyBaseMapper;
import com.gurenkai.demo.infrastructure.persistence.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends EasyBaseMapper<User> {
}
