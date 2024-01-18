package com.tech.challenge.persistence;

import com.tech.challenge.model.User;

import java.util.Optional;

public interface UserPersistence {

    User save(User user);

    Optional<User> findById(Long id);

    Optional<User> findByUsername(String username);
}
