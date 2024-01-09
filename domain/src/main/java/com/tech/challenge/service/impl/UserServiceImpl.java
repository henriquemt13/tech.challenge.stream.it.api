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
    public User create(User user) {
        return persistence.create(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return persistence.findById(id);
    }
}
