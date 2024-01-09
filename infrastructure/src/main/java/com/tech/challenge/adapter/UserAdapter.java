package com.tech.challenge.adapter;

import com.tech.challenge.model.User;
import com.tech.challenge.persistence.UserPersistence;
import com.tech.challenge.repository.UserRepository;

import java.util.Optional;

public class UserAdapter implements UserPersistence {

    private UserRepository repository;

    @Override
    public User create(User user) {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
