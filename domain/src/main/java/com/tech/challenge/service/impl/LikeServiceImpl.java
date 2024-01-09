package com.tech.challenge.service.impl;

import com.tech.challenge.model.Like;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private LikePersistence persistence;

    @Override
    public void likeVideo(Long videoId, Long userId) {
        persistence.likeVideo(videoId, userId);
    }

    @Override
    public void dislikeVideo(Long videoId, Long userId) {
        persistence.dislikeVideo(videoId, userId);
    }

    @Override
    public List<Like> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }
}
