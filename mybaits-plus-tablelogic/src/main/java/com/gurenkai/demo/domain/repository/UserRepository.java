package com.gurenkai.demo.domain.repository;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.gurenkai.demo.infrastructure.mapper.UserMapper;
import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class UserRepository {

    private final UserMapper userMapper;

    public User find(String account){
        return userMapper.selectOne(Wrappers.lambdaQuery(User.class).eq(User::getAccount, account));
    }

    public void add(User user){
        userMapper.insert(user);
    }

    public void remove(User user){
        userMapper.deleteById(user);
    }

    public void recoverByIds(List<Long> ids){
        userMapper.recoverByPk(ids);
    }

    public void recoverByAccounts(List<String> accounts){
        LambdaQueryWrapper<User> wrapper = Wrappers.lambdaQuery(User.class).in(User::getAccount, accounts);
        userMapper.recover(wrapper);
    }

    public void physicalDelete(List<Long> ids){
        userMapper.physicalDeleteByPk(ids);
    }

}
