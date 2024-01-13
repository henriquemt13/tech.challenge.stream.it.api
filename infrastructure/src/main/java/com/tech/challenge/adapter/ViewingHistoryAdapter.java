package com.tech.challenge.adapter;

import com.tech.challenge.mapper.ViewingHistoryEntityMapper;
import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.persistence.ViewingHistoryPersistence;
import com.tech.challenge.repository.ViewingHistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ViewingHistoryAdapter implements ViewingHistoryPersistence {

    private ViewingHistoryRepository repository;
    private ViewingHistoryEntityMapper mapper;

    @Override
    public List<ViewingHistory> findByUserId(Long userId) {
        return mapper.toDomain(repository.findByUserId(userId));
    }
}
