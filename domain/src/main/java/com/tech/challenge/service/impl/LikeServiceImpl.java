package com.tech.challenge.service.impl;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.persistence.LikePersistence;
import com.tech.challenge.service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class LikeServiceImpl implements LikeService {

    private LikePersistence persistence;

    @Override
    public void likeVideo(Long videoId, Long userId) {
        var like = findByUserIdAndVideoId(userId, videoId);
        like.ifPresent(l -> validateLike(l, LikeOptionEnum.LIKE));
        persistence.likeVideo(videoId, userId);
    }

    private void validateLike(Like like, LikeOptionEnum likeOption) {
        if (like.getLikeOption().equals(likeOption)) {
            throw new BadRequestException(String.format("User ID %d has already liked the Video ID %d",
                    like.getUserId(), like.getVideoId()));
        }
        delete(like);
    }

    @Override
    public void dislikeVideo(Long videoId, Long userId) {
        var dislike = findByUserIdAndVideoId(userId, videoId);
        dislike.ifPresent(l -> validateLike(l, LikeOptionEnum.DISLIKE));
        persistence.dislikeVideo(videoId, userId);
    }

    @Override
    public List<Like> findByUserId(Long userId) {
        return persistence.findByUserId(userId);
    }

    @Override
    public Optional<Like> findByUserIdAndVideoId(Long userId, Long videoId) {
        return persistence.findByUserIdAndVideoId(userId, videoId);
    }

    @Override
    public List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum) {
        return persistence.findByUserIdAndLikeOption(userId, likeOptionEnum);
    }

    @Override
    public void delete(Like like) {
        persistence.delete(like);
    }
}
