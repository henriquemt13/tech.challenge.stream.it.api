package com.tech.challenge.persistence;

import com.tech.challenge.model.Like;

import java.util.List;

public interface LikePersistence {

    void likeVideo(Long videoId, Long userId);

    void dislikeVideo(Long videoId, Long userId);

    List<Like> findByUserId(Long userId);
}
