package com.tech.challenge.service.impl;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoPersistence persistence;

    @Override
    public Video uploadVideo(CreateVideoDTO createVideoDTO) {
        return null;
    }

    @Override
    public Video updateVideo(Video video) {
        return null;
    }

    @Override
    public void deleteVideo(Long id, Long userId) {

    }

    @Override
    public Video findById(Long id) {
        return null;
    }

    @Override
    public List<Video> findByVideoNameLike(String name) {
        return null;
    }
}
