package com.gurenkai.demo.domain.repository;

import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@Slf4j
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void recoverByIds() {
        User user1 = buildUser();
        userRepository.add(user1);
        User existingUser1 = userRepository.find("user1");
        assert existingUser1.equals(user1);

        userRepository.remove(existingUser1);
        assert userRepository.find("user1") == null;

        userRepository.recoverByIds(List.of(existingUser1.getId()));
        existingUser1 = userRepository.find("user1");
        assert !existingUser1.isDeleted();

        userRepository.physicalDelete(List.of(existingUser1.getId()));
    }

    @Test
    public void recoverByAccounts() {
        User user1 = buildUser();
        userRepository.add(user1);
        User existingUser1 = userRepository.find("user1");
        assert existingUser1.equals(user1);

        userRepository.remove(existingUser1);
        assert userRepository.find("user1") == null;

        userRepository.recoverByAccounts(List.of("user1"));
        existingUser1 = userRepository.find("user1");
        assert !existingUser1.isDeleted();

        userRepository.physicalDelete(List.of(existingUser1.getId()));
    }

    private User buildUser() {
        return User.builder().account("user1").pwd("123").name("用户1").build();
    }
}