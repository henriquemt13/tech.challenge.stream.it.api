package com.tech.challenge.adapter;

import com.tech.challenge.model.Like;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.repository.LikeRepository;

import java.util.List;

public class LikeAdapter implements LikePersistence {

    private LikeRepository repository;

    @Override
    public void likeVideo(Long videoId, Long userId) {

    }

    @Override
    public void dislikeVideo(Long videoId, Long userId) {

    }

    @Override
    public List<Like> findByUserId(Long userId) {
        return null;
    }
}
