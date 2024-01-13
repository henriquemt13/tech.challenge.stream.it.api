package com.tech.challenge.service;

import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;

import java.util.List;

public interface LikeService {

    void likeVideo(Long videoId, Long userId);

    void dislikeVideo(Long videoId, Long userId);

    List<Like> findByUserId(Long userId);

    List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOptionEnum);

}
