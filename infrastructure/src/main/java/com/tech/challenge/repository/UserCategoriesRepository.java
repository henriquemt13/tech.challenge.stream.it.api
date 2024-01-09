package com.tech.challenge.repository;

import com.tech.challenge.entity.UserCategoriesEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UserCategoriesRepository extends ReactiveCrudRepository<UserCategoriesEntity, Long> {
}
