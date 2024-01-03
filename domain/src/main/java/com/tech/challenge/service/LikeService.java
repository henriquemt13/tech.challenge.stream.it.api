package com.tech.challenge.service;

public interface LikeService {

    void likeVideo(Long videoId, Long userId);

    void dislikeVideo(Long videoId, Long userId);

}
