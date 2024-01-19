package com.tech.challenge.adapter;

import com.tech.challenge.entity.ViewingHistoryEntity;
import com.tech.challenge.mapper.ViewingHistoryEntityMapper;
import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.persistence.ViewingHistoryPersistence;
import com.tech.challenge.repository.ViewingHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ViewingHistoryAdapter implements ViewingHistoryPersistence {

    private final ViewingHistoryRepository repository;
    private final ViewingHistoryEntityMapper mapper;

    @Override
    public List<ViewingHistory> findByUserId(Long userId) {
        return mapper.toDomain(repository.findByUserId(userId));
    }

    @Override
    public void save(Long userId, Long videoId) {
        repository.save(new ViewingHistoryEntity(userId, videoId));
    }

    @Override
    public Long totalViews() {
        return repository.count();
    }
}
