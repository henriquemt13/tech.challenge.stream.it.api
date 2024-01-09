package com.tech.challenge.service;

import com.tech.challenge.model.Like;

import java.util.List;

public interface LikeService {

    void likeVideo(Long videoId, Long userId);

    void dislikeVideo(Long videoId, Long userId);

    List<Like> findByUserId(Long userId);

}
