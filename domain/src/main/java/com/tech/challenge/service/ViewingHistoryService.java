package com.tech.challenge.service;

import com.tech.challenge.model.ViewingHistory;

import java.util.List;

public interface ViewingHistoryService {

    List<ViewingHistory> findByUserId(Long userId);
}
