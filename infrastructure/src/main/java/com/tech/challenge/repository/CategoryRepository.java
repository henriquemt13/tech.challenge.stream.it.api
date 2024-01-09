package com.tech.challenge.repository;

import com.tech.challenge.entity.CategoryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface CategoryRepository extends ReactiveCrudRepository<CategoryEntity, Long> {
}
