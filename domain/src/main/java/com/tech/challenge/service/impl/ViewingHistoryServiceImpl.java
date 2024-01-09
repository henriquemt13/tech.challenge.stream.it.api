package com.tech.challenge.service.impl;

import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.persistence.ViewingHistoryPersistence;
import com.tech.challenge.service.ViewingHistoryService;

import java.util.List;

public class ViewingHistoryServiceImpl implements ViewingHistoryService {

    private ViewingHistoryPersistence persistence;

    @Override
    public List<ViewingHistory> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }
}
