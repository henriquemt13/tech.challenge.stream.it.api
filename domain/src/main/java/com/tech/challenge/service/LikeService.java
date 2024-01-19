package com.tech.challenge.service;

import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;

import java.util.List;
import java.util.Optional;

public interface LikeService {

    void likeVideo(Long videoId, Long userId);

    void dislikeVideo(Long videoId, Long userId);

    List<Like> findByUserId(Long userId);

    Optional<Like> findByUserIdAndVideoId(Long userId, Long videoId);

    List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum);

    void delete(Like like);

    Long findTotalInteractions();

    Long findTotalLikes();

}
