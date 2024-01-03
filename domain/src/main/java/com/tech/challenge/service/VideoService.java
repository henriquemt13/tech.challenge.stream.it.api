package com.tech.challenge.service;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.model.Video;

import java.util.List;

public interface VideoService {

    Video uploadVideo(CreateVideoDTO createVideoDTO);

    Video updateVideo(Video video);

    void deleteVideo(Long id, Long userId);

    Video findById(Long id);

    List<Video> findByVideoNameLike(String name);

}
