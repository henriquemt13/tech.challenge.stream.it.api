package com.tech.challenge.controller.v1;

import com.tech.challenge.dto.request.CreateVideoRequestDTO;
import com.tech.challenge.dto.response.UserResponseDTO;
import com.tech.challenge.dto.response.VideoResponseDTO;
import com.tech.challenge.mapper.VideoMapper;
import com.tech.challenge.model.LikeOptionEnum;
import com.tech.challenge.usecase.UserUseCases;
import com.tech.challenge.usecase.VideoUseCases;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/video", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Video")
public class VideoController {

    private VideoUseCases videoUseCases;
    private UserUseCases userUseCases;
    private VideoMapper videoMapper;

    @GetMapping("/{id}")
    @ApiResponse(description = "Find Video Details By Id", responseCode = "200")
    @Operation(summary = "Find Video Details By Id")
    public ResponseEntity<Mono<VideoResponseDTO>> findVideoDetailsById(@Valid @PathVariable Long videoId) {

        return ResponseEntity.ok(videoMapper.toResponse(videoUseCases.findDetailsById(videoId)));
    }

    @GetMapping(value = "/stream/{path}")
    @ApiResponse(description = "Stream Video by its Path", responseCode = "200")
    @Operation(summary = "Stream Video")
    public ResponseEntity<Mono<Resource>> streamVideo(@Valid @PathVariable String videoPath)
            throws MalformedURLException {

        return ResponseEntity.ok(videoUseCases.streamVideo(videoPath));

    }

    @GetMapping("/recommended/{userId}")
    @ApiResponse(description = "Find Video Details By Id", responseCode = "200")
    @Operation(summary = "Find Video Details By Id")
    public ResponseEntity<Flux<VideoResponseDTO>> findRecommendedVideosByUserId(@Valid @PathVariable Long userId) {
        userUseCases.findById(userId);
        return ResponseEntity.ok(videoMapper.toResponse(videoUseCases.findRecommendedVideos(userId)));
    }

    @GetMapping("/liked/{userId}")
    @ApiResponse(description = "Find User Liked Videos By Id", responseCode = "200")
    @Operation(summary = "Find User Liked Videos By Id")
    public ResponseEntity<Flux<VideoResponseDTO>> findLikedVideosByUserId(@Valid @PathVariable Long userId) {
        userUseCases.findById(userId);
        return ResponseEntity.ok(videoMapper.toResponse(videoUseCases.findUserInteractedVideos(userId, LikeOptionEnum.LIKE)));
    }

    @GetMapping("/disliked/{userId}")
    @ApiResponse(description = "Find User Disliked Videos By Id", responseCode = "200")
    @Operation(summary = "Find User Disliked Videos By Id")
    public ResponseEntity<Flux<VideoResponseDTO>> findDislikedVideosByUserId(@Valid @PathVariable Long userId) {
        userUseCases.findById(userId);
        return ResponseEntity.ok(videoMapper.toResponse(videoUseCases.findUserInteractedVideos(userId, LikeOptionEnum.DISLIKE)));
    }

    @GetMapping("/last-viewed/{userId}")
    @ApiResponse(description = "Find User Last Viewed Videos by Its Id", responseCode = "200")
    @Operation(summary = "Find User Last Viewed Videos by User Id")
    public ResponseEntity<Flux<VideoResponseDTO>> findUserLastViewedVideosByUserId(@Valid @PathVariable Long userId) {
        userUseCases.findById(userId);
        return ResponseEntity.ok(videoMapper.toResponse(videoUseCases.findLastViewedVideos(userId)));
    }

    @GetMapping("/like/{userId}/{videoId}")
    @ApiResponse(description = "Like video by User and Video Id", responseCode = "200")
    @Operation(summary = "Like video by User and Video Id")
    public ResponseEntity<Flux<VideoResponseDTO>> likeVideo(@Valid @PathVariable Long userId,
                                                            @Valid @PathVariable Long videoId) {
        userUseCases.findById(userId);
        videoUseCases.likeVideo(videoId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/dislike/{userId}/{videoId}")
    @ApiResponse(description = "Dislike video by User and Video Id", responseCode = "200")
    @Operation(summary = "Dislike video by User and Video Id")
    public ResponseEntity<Flux<VideoResponseDTO>> dislikeVideo(@Valid @PathVariable Long userId,
                                                               @Valid @PathVariable Long videoId) {
        userUseCases.findById(userId);
        videoUseCases.dislikeVideo(videoId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{userId}")
    @ApiResponse(description = "Upload video", responseCode = "200")
    @Operation(summary = "Upload video")
    public ResponseEntity<Mono<VideoResponseDTO>> uploadVideo(@Valid @PathVariable Long userId,
                                                              @Valid @ParameterObject CreateVideoRequestDTO requestDTO) throws IOException {
        userUseCases.findById(userId);
        return ResponseEntity.ok(videoMapper
                .toResponse(videoUseCases.uploadVideo(videoMapper.createRequestToDomain(requestDTO))));
    }

    @DeleteMapping("/{userId}/{videoId}")
    @ApiResponse(description = "Delete video", responseCode = "200")
    @Operation(summary = "Delete video")
    public ResponseEntity<Mono<VideoResponseDTO>> deleteVideo(@Valid @PathVariable Long userId,
                                                              @Valid @PathVariable Long videoId) {
        userUseCases.findById(userId);
        videoUseCases.deleteVideo(videoId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/search")
    @ApiResponse(description = "Dislike video by User and Video Id", responseCode = "200")
    @Operation(summary = "Dislike video by User and Video Id")
    public ResponseEntity<Flux<VideoResponseDTO>> dislikeVideo(@Valid @RequestParam String videoName) {
        return ResponseEntity.ok(videoMapper
                .toResponse(videoUseCases.findByVideoNameLike(videoName)));
    }
}
