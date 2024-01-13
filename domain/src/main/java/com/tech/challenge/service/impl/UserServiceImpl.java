package com.tech.challenge.service.impl;

import com.tech.challenge.model.User;
import com.tech.challenge.persistence.UserPersistence;
import com.tech.challenge.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserPersistence persistence;

    @Override
    public User save(User user) {
        return persistence.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return persistence.findById(id);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return persistence.findByUsername(username);
    }
}
