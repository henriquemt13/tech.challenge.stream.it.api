package com.tech.challenge.service.impl;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VideoServiceImpl implements VideoService {

    private VideoPersistence persistence;

    @Override
    public Video upload(CreateVideoDTO createVideoDTO) throws IOException {
        return persistence.save(new Video(createVideoDTO));
    }

    @Override
    public Video update(Video video) {
        return persistence.update(video);
    }

    @Override
    public void delete(Long id, Long userId) {
        findById(id).ifPresentOrElse(video -> {
            if (Objects.equals(video.getUploaderUserId(), userId)) {
                persistence.deleteVideo(id);
            } else {
                throw new BadRequestException(String.format("User ID %d is not the Video ID %d owner", userId, id));
            }
        }, () -> {
            throw new NotFoundException(String.format("Video ID %d not found", id));
        });
    }

    @Override
    public Optional<Video> findById(Long id) {
        return persistence.findById(id);
    }

    @Override
    public List<Video> findByIdIn(List<Long> ids) {
        return persistence.findByIdIn(ids);
    }

    @Override
    public List<Video> findByVideoNameLike(String name) {
        return persistence.findByVideoNameLike(name);
    }

    @Override
    public List<Video> findRecommendedVideosByUserId(Long userId) {
        return persistence.findRecommendedVideosByUserId(userId);
    }
}
