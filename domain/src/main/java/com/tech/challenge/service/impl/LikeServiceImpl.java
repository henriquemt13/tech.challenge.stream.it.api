package com.tech.challenge.service.impl;

import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

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

    @Override
    public List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum) {
        return persistence.findByUserIdAndLikeOption(userId, likeOptionEnum);
    }
}
