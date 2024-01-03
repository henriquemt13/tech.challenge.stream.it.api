package com.tech.challenge.usecase;

import com.tech.challenge.model.Video;
import com.tech.challenge.service.LikeService;
import com.tech.challenge.service.UserService;
import com.tech.challenge.service.VideoService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class VideoUseCases {

    private LikeService likeService;
    private UserService userService;
    private VideoService videoService;


    public List<Video> findRecommendedVideosByUserId(Long userId) {
        return new ArrayList<>();
    }

    public List<Video> findLikedVideosByUserId(Long userId) {
        return new ArrayList<>();
    }

    public Video findMostLikedVideo() {
        return new Video();
    }

}
