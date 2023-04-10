package com.gurenkai.demo.interfaces.rest;

import com.gurenkai.demo.domain.repository.UserRepository;
import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserRepository userRepository;

    @PostMapping
    public void add(@RequestBody User user) {
        userRepository.add(user);
    }

}
