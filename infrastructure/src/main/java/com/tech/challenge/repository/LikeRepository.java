package com.tech.challenge.repository;

import com.tech.challenge.entity.LikeEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface LikeRepository extends ReactiveCrudRepository<LikeEntity, Long> {
}
