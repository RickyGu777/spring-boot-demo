package com.gurenkai.demo.interfaces.rest;

import com.gurenkai.demo.domain.repository.UserRepository;
import com.gurenkai.demo.infrastructure.persistence.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/user")
public class UserApi {

    private final UserRepository userRepository;

    @GetMapping("/{id}")
    public User get(@PathVariable("id") Long id) {
        return userRepository.find(id);
    }

    @PostMapping
    public Long add(@RequestBody User user) {
        return userRepository.add(user);
    }

    @PostMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        userRepository.remove(id);
    }

}
