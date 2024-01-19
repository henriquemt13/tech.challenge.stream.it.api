package com.tech.challenge.service.impl;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.model.Video;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.service.VideoCategoriesService;
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

    private final VideoPersistence persistence;
    private final VideoCategoriesService videoCategoriesService;

    @Override
    public Video upload(CreateVideoDTO createVideoDTO) throws IOException {
        var video = persistence.save(new Video(createVideoDTO), createVideoDTO.getVideo());
        videoCategoriesService.save(video.getId(), createVideoDTO.getCategoryIds());
        return video;
    }
    @Override
    public void delete(Long id, Long userId) {
        var existentVideo = findById(id);
        if (existentVideo.isEmpty()) {
            throw new NotFoundException(String.format("Video ID %d not found", id));
        }
        deleteVideo(existentVideo.get(), userId);
    }

    private void deleteVideo(Video video, Long userId) {
        if (!Objects.equals(video.getUploaderUserId(), userId)) {
            throw new BadRequestException(String
                    .format("User ID %d is not the Video ID %d owner", userId, video.getId()));
        }
        try {
            persistence.delete(video);
        }  catch (IOException e) {
            throw new BadRequestException(String
                    .format("There was an error while trying to delete Video ID %d", video.getId()));
        }
    }

    @Override
    public Optional<Video> findById(Long id) {
        return persistence.findById(id);
    }

    @Override
    public SearchResultDTO<Video> findByIdIn(List<Long> ids, SearchVideoDTO searchVideoDTO) {
        return persistence.findByIdIn(ids, searchVideoDTO);
    }

    @Override
    public List<Video> findByIdIn(List<Long> ids) {
        return persistence.findByIdIn(ids);
    }

    @Override
    public Optional<Video> findByVideoPath(String videoPath) {
        return persistence.findByVideoPath(videoPath);
    }

    @Override
    public List<Video> findRecommendedVideosByUserId(Long userId) {
        return persistence.findRecommendedVideosByUserId(userId);
    }

    @Override
    public SearchResultDTO<Video> findAll(SearchVideoDTO searchVideoDTO) {
        return persistence.findAll(searchVideoDTO);
    }

    @Override
    public Long findTotalVideos() {
        return persistence.totalVideos();
    }
}
