package com.gurenkai.demo.domain.repository;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gurenkai.demo.infrastructure.mapper.UserMapper;
import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRepository {

    private final UserMapper userMapper;

    public User find(String account) {
        return userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getAccount, account));
    }

    public void add(User user) {
        userMapper.insert(user);
    }

    public void remove(User user) {
        userMapper.deleteById(user);
    }

}
