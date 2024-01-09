package com.tech.challenge.adapter;

import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.persistence.ViewingHistoryPersistence;
import com.tech.challenge.repository.ViewingHistoryRepository;

import java.util.List;

public class ViewingHistoryAdapter implements ViewingHistoryPersistence {

    private ViewingHistoryRepository repository;

    @Override
    public List<ViewingHistory> findByUserId(Long userId) {
        return null;
    }
}
