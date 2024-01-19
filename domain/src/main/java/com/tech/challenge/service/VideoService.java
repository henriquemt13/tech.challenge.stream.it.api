package com.tech.challenge.service;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.model.Video;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface VideoService {

    Video upload(CreateVideoDTO createVideoDTO) throws IOException;

    void delete(Long id, Long userId);

    Optional<Video> findById(Long id);

    List<Video> findByIdIn(List<Long> ids);

    List<Video> findByVideoNameLike(String name);

    Optional<Video> findByVideoPath(String videoPath);

    List<Video> findRecommendedVideosByUserId(Long userId);

    List<Video> findAll();
}
