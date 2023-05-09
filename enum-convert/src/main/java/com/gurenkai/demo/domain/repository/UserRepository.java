package com.gurenkai.demo.domain.repository;

import com.gurenkai.demo.infrastructure.mapper.UserMapper;
import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserRepository {

    private final UserMapper userMapper;

    public User find(Long id) {
        return userMapper.selectById(id);
    }

    public Long add(User user) {
        userMapper.insert(user);
        return user.getId();
    }

    public void remove(Long id) {
        userMapper.deleteById(id);
    }

}
