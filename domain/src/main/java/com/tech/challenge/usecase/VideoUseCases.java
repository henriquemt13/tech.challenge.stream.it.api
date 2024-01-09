package com.tech.challenge.usecase;

import com.tech.challenge.model.*;
import com.tech.challenge.service.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Component
@AllArgsConstructor
public class VideoUseCases {

    private LikeService likeService;
    private VideoService videoService;
    private VideoCategoriesService videoCategoriesService;
    private UserCategoriesService userCategoriesService;
    private ViewingHistoryService viewingHistoryService;


    public List<Video> findRecommendedVideosByUserId(Long userId) {
        List<Video> recommendedVideos = searchRecommendedVideos(searchRecommendedCategoriesIdsByUserId(userId));
        removeViewedVideos(searchViewedVideosHistoryIdsByUserId(userId), recommendedVideos);
        recommendedVideos.sort(Comparator.comparing(Video::getUploadDate));
        return recommendedVideos;
    }

    public List<Video> searchRecommendedVideos(List<Long> likedCategoriesIds) {
        return videoService.findByIdIn(videoCategoriesService
                .findByCategoryIdIn(likedCategoriesIds).stream().map(VideoCategories::getCategoryId).toList());
    }

    public List<Long> searchRecommendedCategoriesIdsByUserId(Long userId) {
        List<Long> likedCategories = new ArrayList<>(userCategoriesService
                .findByUserIdAndLikeOption(userId, LikeOptionEnum.LIKE)
                .stream().map(UserCategories::getCategoryId).toList());

        likedCategories.addAll(searchLastLikedVideoCategoriesIdsByUserId(userId));
        return likedCategories.stream().distinct().toList();
    }

    public List<Long> searchLastLikedVideoCategoriesIdsByUserId(Long userId) {
        List<Like> likedVideos = likeService.findByUserId(userId);
        likedVideos.sort(Comparator.comparing(Like::getCreatedAt));
        return videoCategoriesService
                .findByVideoId(likedVideos.get(0).getVideoId())
                .stream().map(VideoCategories::getCategoryId).toList();
    }

    private List<Long> searchViewedVideosHistoryIdsByUserId(Long userId) {
        return viewingHistoryService
                .findByUserId(userId).stream().map(ViewingHistory:: getVideoId).toList();
    }

    public void removeViewedVideos(List<Long> viewedVideosIds, List<Video> recommendedVideos) {
        for (Long viewedVideoId: viewedVideosIds) {
            recommendedVideos.removeIf( r-> r.getId().equals(viewedVideoId));
        }
    }

    public List<Video> findLikedVideosByUserId(Long userId) {
        List<Like> likes = likeService.findByUserId(userId);
        return new ArrayList<>(videoService.findByIdIn(likes.stream()
                .filter(l -> l.getLikeOption().equals(LikeOptionEnum.LIKE))
                .map(Like::getVideoId).toList()));
    }

    public List<Video> findDislikedVideosByUserId(Long userId) {
        List<Like> likes = likeService.findByUserId(userId);
        return new ArrayList<>(videoService.findByIdIn(likes.stream()
                .filter(l -> l.getLikeOption().equals(LikeOptionEnum.DISLIKE))
                .map(Like::getVideoId).toList()));
    }


    public Video findMostLikedVideo() {
        return new Video();
    }

}
