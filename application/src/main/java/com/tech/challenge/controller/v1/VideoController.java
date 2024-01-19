package com.tech.challenge.controller.v1;

import com.tech.challenge.dto.request.CreateVideoRequestDTO;
import com.tech.challenge.dto.request.SearchVideoRequestDTO;
import com.tech.challenge.dto.response.MetricsResponseDTO;
import com.tech.challenge.dto.response.SearchResultResponseDTO;
import com.tech.challenge.dto.response.VideoResponseDTO;
import com.tech.challenge.mapper.MetricsMapper;
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
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/video", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Video")
public class VideoController {

    private final VideoUseCases videoUseCases;
    private final UserUseCases userUseCases;
    private final VideoMapper mapper;
    private final MetricsMapper metricsMapper;

    @GetMapping
    @ApiResponse(description = "Find All Videos", responseCode = "200")
    @Operation(summary = "Find All")
    public ResponseEntity<SearchResultResponseDTO<VideoResponseDTO>> findAll(
            @ParameterObject SearchVideoRequestDTO searchVideoRequestDTO) {
        log.info("Searching for all Videos");
        return ResponseEntity.ok(mapper.toResponse(videoUseCases
                .findAll(mapper.createRequestToDomain(searchVideoRequestDTO))));
    }

    @GetMapping("/metrics")
    @ApiResponse(description = "Find All Metrics", responseCode = "200")
    @Operation(summary = "Find Metrics")
    public ResponseEntity<MetricsResponseDTO> findMetrics() {
        log.info("Searching for all Metrics");
        return ResponseEntity.ok(metricsMapper.toResponse(videoUseCases
                .findMetrics()));
    }

    @GetMapping("/category/{id}")
    @ApiResponse(description = "Find All Metrics", responseCode = "200")
    @Operation(summary = "Find Metrics")
    public ResponseEntity<SearchResultResponseDTO<VideoResponseDTO>> findByCategoryId(@Valid @PathVariable("id") Long id,
                                                               @ParameterObject SearchVideoRequestDTO searchVideoRequestDTO) {
        log.info("Searching for all Videos in Category ID {}", id);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases
                .findByCategoryId(id, mapper.createRequestToDomain(searchVideoRequestDTO))));
    }


    @GetMapping("/{id}")
    @ApiResponse(description = "Find Video Details By Id", responseCode = "200")
    @Operation(summary = "Find Video Details By Id")
    public ResponseEntity<VideoResponseDTO> findVideoDetailsById(@Valid @PathVariable("id") Long videoId) {
        log.info("Searching details for Videos ID {}", videoId);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases.findDetailsById(videoId)));
    }

    @GetMapping(value = "/stream/{id}/{path}", produces = "video/mp4")
    @ApiResponse(description = "Stream Video by its Path", responseCode = "200")
    @Operation(summary = "Stream Video")
    public ResponseEntity<Mono<Resource>> streamVideo(@Valid @PathVariable("path") String videoPath,
                                                      @Valid @PathVariable("id") Long userId)
            throws MalformedURLException {
        log.info("Streaming video Path {}", videoPath);
        return ResponseEntity.ok(videoUseCases.streamVideo(videoPath, userId));

    }

    @GetMapping("/recommended/{id}")
    @ApiResponse(description = "Find Recommended Video By User Id", responseCode = "200")
    @Operation(summary = "Find Recommended Video By User Id")
    public ResponseEntity<List<VideoResponseDTO>> findRecommendedVideosByUserId(@Valid @PathVariable("id") Long userId) {
        log.info("Searching for all recommended Videos for User ID {}", userId);
        userUseCases.findById(userId);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases.findRecommendedVideos(userId)));
    }

    @GetMapping("/liked/{id}")
    @ApiResponse(description = "Find Liked Videos By User Id", responseCode = "200")
    @Operation(summary = "Find User Liked Videos By Id")
    public ResponseEntity<List<VideoResponseDTO>> findLikedVideosByUserId(@Valid @PathVariable("id") Long userId) {
        log.info("Searching for all liked Videos for User ID {}", userId);
        userUseCases.findById(userId);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases.findUserInteractedVideos(userId, LikeOptionEnum.LIKE)));
    }

    @GetMapping("/disliked/{id}")
    @ApiResponse(description = "Find User Disliked Videos By Id", responseCode = "200")
    @Operation(summary = "Find User Disliked Videos By Id")
    public ResponseEntity<List<VideoResponseDTO>> findDislikedVideosByUserId(@Valid @PathVariable("id") Long userId) {
        log.info("Searching for all disliked Videos for User ID {}", userId);
        userUseCases.findById(userId);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases.findUserInteractedVideos(userId, LikeOptionEnum.DISLIKE)));
    }

    @GetMapping("/last-viewed/{id}")
    @ApiResponse(description = "Find User Last Viewed Videos by Its Id", responseCode = "200")
    @Operation(summary = "Find User Last Viewed Videos by User Id")
    public ResponseEntity<List<VideoResponseDTO>> findUserLastViewedVideosByUserId(@Valid @PathVariable("id") Long userId) {
        log.info("Searching for all last Viewed Videos for User ID {}", userId);
        userUseCases.findById(userId);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases.findLastViewedVideos(userId)));
    }

    @PostMapping("/like/{userId}/{videoId}")
    @ApiResponse(description = "Like video by User and Video Id", responseCode = "200")
    @Operation(summary = "Like video by User and Video Id")
    public ResponseEntity<Void> likeVideo(@Valid @PathVariable("userId") Long userId,
                                                            @Valid @PathVariable("videoId") Long videoId) {
        log.info("Like Video ID {} for User ID {}", videoId, userId);
        userUseCases.findById(userId);
        videoUseCases.likeVideo(videoId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/dislike/{userId}/{videoId}")
    @ApiResponse(description = "Dislike video by User and Video Id", responseCode = "200")
    @Operation(summary = "Dislike video by User and Video Id")
    public ResponseEntity<Void> dislikeVideo(@Valid @PathVariable("userId") Long userId,
                                                               @Valid @PathVariable("videoId") Long videoId) {
        log.info("Dislike Video ID {} for User ID {}", videoId, userId);
        userUseCases.findById(userId);
        videoUseCases.dislikeVideo(videoId, userId);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/{id}", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    @ApiResponse(description = "Upload video", responseCode = "200")
    @Operation(summary = "Upload video")
    public ResponseEntity<VideoResponseDTO> uploadVideo(@Valid @PathVariable("id") Long userId,
                                                              @Valid @ModelAttribute CreateVideoRequestDTO requestDTO) throws IOException {
        log.info("Upload a new Video for User ID {}", userId);
        userUseCases.findById(userId);
        return ResponseEntity.ok(mapper.toResponse(videoUseCases.uploadVideo(mapper.createRequestToDomain(requestDTO, userId))));
    }

    @DeleteMapping("/{userId}/{videoId}")
    @ApiResponse(description = "Delete video", responseCode = "200")
    @Operation(summary = "Delete video")
    public ResponseEntity<Void> deleteVideo(@Valid @PathVariable("userId") Long userId,
                                                              @Valid @PathVariable("videoId") Long videoId) {
        log.info("Delete Video ID {} using User ID {}", videoId, userId);
        userUseCases.findById(userId);
        videoUseCases.deleteVideo(videoId, userId);
        return ResponseEntity.ok().build();
    }
}
