package com.tech.challenge.repository;

import com.tech.challenge.entity.VideoCategoriesEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VideoCategoriesRepository extends ReactiveCrudRepository<VideoCategoriesEntity, Long> {
}
