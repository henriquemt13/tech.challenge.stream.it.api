package com.tech.challenge.repository;

import com.tech.challenge.entity.ViewingHistoryEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ViewingHistoryRepository extends ReactiveCrudRepository<ViewingHistoryEntity, Long> {
}
