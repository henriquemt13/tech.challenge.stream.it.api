package com.tech.challenge.usecase;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.model.Like;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.model.Video;
import com.tech.challenge.model.ViewingHistory;
import com.tech.challenge.service.LikeService;
import com.tech.challenge.service.VideoService;
import com.tech.challenge.service.ViewingHistoryService;
import com.tech.challenge.storage.VideoStorage;
import lombok.AllArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;

@Component
@AllArgsConstructor
public class VideoUseCases {

    private LikeService likeService;
    private VideoService videoService;
    private ViewingHistoryService viewingHistoryService;
    private VideoStorage storage;

    public Mono<Video> uploadVideo(CreateVideoDTO createVideoDTO) throws IOException {
        return videoService.upload(createVideoDTO);
    }

    public Mono<Resource> streamVideo(String videoPath) throws MalformedURLException {
        return storage.streamVideo(videoPath);
    }

    public void deleteVideo(Long videoId, Long userId) {
        videoService.delete(videoId, userId);
    }

    public Flux<Video> findByVideoNameLike(String videoName) {
        return videoService.findByVideoNameLike(videoName);
    }

    public void likeVideo(Long videoId, Long userId) {
        likeService.likeVideo(videoId, userId);
    }

    public void dislikeVideo(Long videoId, Long userId) {
        likeService.dislikeVideo(videoId, userId);
    }

    public Mono<Video> findDetailsById(Long id) {
        return videoService.findById(id);
    }

    public Flux<Video> findUserInteractedVideos(Long userId, LikeOptionEnum likeOption) {
        return videoService.findByIdIn(likeService.findByUserIdAndLikeOption(userId, likeOption).stream()
                .map(Like::getVideoId).toList());
    }

    public Flux<Video> findLastViewedVideos(Long userId) {
        return videoService.findByIdIn(viewingHistoryService
                .findByUserId(userId).stream().map(ViewingHistory::getVideoId).toList());
    }

    public Flux<Video> findRecommendedVideos(Long userId) {
        return videoService.findRecommendedVideosByUserId(userId);
    }
}
