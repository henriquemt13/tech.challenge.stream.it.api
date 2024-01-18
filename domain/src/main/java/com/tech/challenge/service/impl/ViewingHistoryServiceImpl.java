package com.tech.challenge.service.impl;

import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.persistence.ViewingHistoryPersistence;
import com.tech.challenge.service.ViewingHistoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class ViewingHistoryServiceImpl implements ViewingHistoryService {

    private final ViewingHistoryPersistence persistence;

    @Override
    public List<ViewingHistory> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }

    @Override
    public void addView(Long userId, Long videoId) {
        persistence.save(userId, videoId);
    }
}
