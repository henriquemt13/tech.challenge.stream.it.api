package com.tech.challenge.service;

import com.tech.challenge.model.User;

import java.util.Optional;


public interface UserService {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
}
