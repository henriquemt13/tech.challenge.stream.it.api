package com.tech.challenge.persistence;

import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;

import java.util.List;
import java.util.Optional;

public interface LikePersistence {

    void likeVideo(Long videoId, Long userId);

    void dislikeVideo(Long videoId, Long userId);

    List<Like> findByUserId(Long userId);

    List<Like> findByUserIdAndLikeOption(Long userId, LikeOptionEnum likeOption);

    Optional<Like> findByUserIdAndVideoId(Long userId, Long videoId);

    void delete(Like like);
}
