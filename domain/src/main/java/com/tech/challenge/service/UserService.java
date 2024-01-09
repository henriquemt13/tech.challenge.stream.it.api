package com.tech.challenge.service;

import com.tech.challenge.model.User;

import java.util.Optional;

public interface UserService {

    User create(User user);

    Optional<User> findById(Long id);
}
