package com.tech.challenge.persistence;

import com.tech.challenge.model.Video;

import java.util.List;
import java.util.Optional;

public interface VideoPersistence {

    Video save(Video video);

    Video update(Video video);

    void deleteVideo(Long id);

    Optional<Video> findById(Long id);

    List<Video> findByIdIn(List<Long> ids);

    List<Video> findByVideoNameLike(String name);

    List<Video> findRecommendedVideosByUserId(Long userId);
}
