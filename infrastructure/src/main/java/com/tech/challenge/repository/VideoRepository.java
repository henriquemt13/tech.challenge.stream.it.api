package com.tech.challenge.repository;

import com.tech.challenge.entity.VideoEntity;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface VideoRepository extends ReactiveCrudRepository<VideoEntity, Long> {
}
