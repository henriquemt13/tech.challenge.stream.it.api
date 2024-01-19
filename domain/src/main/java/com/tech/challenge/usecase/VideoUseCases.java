package com.tech.challenge.usecase;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.MetricsDTO;
import com.tech.challenge.dto.SearchResultDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.exception.NotFoundException;
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
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Component
@AllArgsConstructor
public class VideoUseCases {

    private final LikeService likeService;
    private final VideoService videoService;
    private final ViewingHistoryService viewingHistoryService;
    private final VideoStorage storage;
    private final CategoryUseCases categoryUseCases;

    public SearchResultDTO<Video> findByCategoryId(Long categoryId, SearchVideoDTO searchVideoDTO) {
        return videoService.findByIdIn(categoryUseCases.findVideosIdsByCategoryId(categoryId), searchVideoDTO);
    }

    public MetricsDTO findMetrics() {
        MetricsDTO metricsDTO = new MetricsDTO();
        metricsDTO.setTotalVideos(videoService.findTotalVideos());
        metricsDTO.setTotalLikes(likeService.findTotalLikes());
        metricsDTO.setTotalInteractions(likeService.findTotalInteractions());
        metricsDTO.setTotalViews(viewingHistoryService.findTotalViews());

        return metricsDTO;
    }

    public SearchResultDTO<Video> findAll(SearchVideoDTO searchVideoDTO) {
        return videoService.findAll(searchVideoDTO);
    }
    public Video uploadVideo(CreateVideoDTO createVideoDTO) throws IOException {
        return videoService.upload(createVideoDTO);
    }

    public Mono<Resource> streamVideo(String videoPath, Long userId) throws MalformedURLException {
        var video = videoService.findByVideoPath(videoPath);
        if (video.isEmpty()) {
            throw new NotFoundException("Video Path not Found");
        }
        viewingHistoryService.addView(userId, video.get().getId());
        return storage.streamVideo(videoPath);
    }

    public void deleteVideo(Long videoId, Long userId) {
        videoService.delete(videoId, userId);
    }

    public void likeVideo(Long videoId, Long userId) {
        likeService.likeVideo(videoId, userId);
    }

    public void dislikeVideo(Long videoId, Long userId) {
        likeService.dislikeVideo(videoId, userId);
    }

    public Video findDetailsById(Long id) {
        var video =  videoService.findById(id);
        if (video.isPresent()) {
            return video.get();
        }
        throw new NotFoundException(String.format("Video ID %d not found", id));
    }

    public List<Video> findUserInteractedVideos(Long userId, LikeOptionEnum likeOption) {
        return videoService.findByIdIn(likeService.findByUserIdAndLikeOption(userId, likeOption).stream()
                .map(Like::getVideoId).toList());
    }

    public List<Video> findLastViewedVideos(Long userId) {
        return videoService.findByIdIn(viewingHistoryService
                .findByUserId(userId).stream().map(ViewingHistory::getVideoId).toList());
    }

    public List<Video> findRecommendedVideos(Long userId) {
        return videoService.findRecommendedVideosByUserId(userId);
    }
}
