package com.tech.challenge.persistence;

import com.tech.challenge.model.ViewingHistory;

import java.util.List;

public interface ViewingHistoryPersistence {

    List<ViewingHistory> findByUserId(Long userId);

    void save(Long userid, Long videoId);
}
