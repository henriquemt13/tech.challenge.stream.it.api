package com.tech.challenge.repository;

import com.tech.challenge.entity.UserEntity;
import com.tech.challenge.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<UserEntity, Long> {

    Optional<UserEntity> findByUsername(String username);
}
