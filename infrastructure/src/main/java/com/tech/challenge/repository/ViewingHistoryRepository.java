package com.tech.challenge.repository;

import com.tech.challenge.entity.ViewingHistoryEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ViewingHistoryRepository extends CrudRepository<ViewingHistoryEntity, Long> {

    List<ViewingHistoryEntity> findByUserId(Long userId);
}
