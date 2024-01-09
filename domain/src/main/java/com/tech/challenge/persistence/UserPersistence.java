package com.tech.challenge.persistence;

import com.tech.challenge.model.User;

import java.util.Optional;

public interface UserPersistence {

    User create(User user);

    Optional<User> findById(Long id);
}
