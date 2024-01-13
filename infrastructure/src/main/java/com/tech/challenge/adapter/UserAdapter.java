package com.tech.challenge.adapter;

import com.tech.challenge.mapper.UserEntityMapper;
import com.tech.challenge.model.User;
import com.tech.challenge.persistence.UserPersistence;
import com.tech.challenge.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserAdapter implements UserPersistence {

    private UserRepository repository;
    private UserEntityMapper mapper;

    @Override
    public User save(User user) {
        return mapper.toDomain(repository.save(mapper.toEntity(user)));
    }

    @Override
    public Optional<User> findById(Long id) {
        return mapper.toDomain(repository.findById(id));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return mapper.toDomain(repository.findByUsername(username));
    }
}
