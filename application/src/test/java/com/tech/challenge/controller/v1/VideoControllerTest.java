package com.tech.challenge.controller.v1;

import com.tech.challenge.config.TestConfig;
import com.tech.challenge.dto.request.CreateVideoRequestDTO;
import com.tech.challenge.fixture.CreateVideoRequestDTOFixture;
import com.tech.challenge.fixture.MetricsResponseDTOFixture;
import com.tech.challenge.fixture.UserFixture;
import com.tech.challenge.fixture.VideoFixture;
import com.tech.challenge.mapper.MetricsMapper;
import com.tech.challenge.mapper.UserMapper;
import com.tech.challenge.mapper.VideoMapper;
import com.tech.challenge.model.Video;
import com.tech.challenge.usecase.UserUseCases;
import com.tech.challenge.usecase.VideoUseCases;
import com.tech.challenge.utils.FileUtils;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(VideoController.class)
@Import({VideoController.class})
@ContextConfiguration(classes = TestConfig.class)
class VideoControllerTest {

    private static final String PATH = "/video";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private VideoUseCases videoUseCases;

    @MockBean
    private UserUseCases userUseCases;

    @MockBean
    private VideoMapper mapper;

    @MockBean
    private MetricsMapper metricsMapper;

    @BeforeEach
    void setupMockMvc() {
        this.mvc = MockMvcBuilders
                .standaloneSetup(new VideoController(videoUseCases, userUseCases, mapper, metricsMapper))
                .addFilter(((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })).build();
    }

    @Test
    void findMetricsShouldRunAsExpected() throws Exception {
        when(videoUseCases.findMetrics()).thenReturn(MetricsResponseDTOFixture.newMetricsDTO());
        var result = mvc.perform(
                get(PATH + "/metrics")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findMetrics();

    }

    @Test
    void findByCategoryIdShouldRunAsExpected() throws Exception {
        when(videoUseCases.findByCategoryId(anyLong(), any()))
                .thenReturn(VideoFixture.newVideoResult());
        var result = mvc.perform(
                get(PATH + "/category/{id}", 1L)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findByCategoryId(anyLong(), any());
    }

    @Test
    void findAllShouldRunAsExpected() throws Exception {
        when(videoUseCases.findAll(any())).thenReturn(VideoFixture.newVideoResult());

        var result = mvc.perform(
                get(PATH)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findAll(any());
    }

    @Test
    void findVideoDetailsByIdShouldRunAsExpected() throws Exception {
        long videoId = 1L;
        when(videoUseCases.findDetailsById(anyLong())).thenReturn(VideoFixture.newVideo());

        var result = mvc.perform(
                get(PATH + "/{id}", videoId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findDetailsById(anyLong());
    }

    @Test
    void streamVideoShouldRunAsExpected() throws Exception {
        long userId = 1L;
        String videoPath = "samplePath";
        byte[] videoContent = "sampleVideoContent".getBytes();
        Resource mockResource = new ByteArrayResource(videoContent);

        when(videoUseCases.streamVideo(videoPath, userId)).thenReturn(Mono.just(mockResource));

        var result = mvc.perform(
                get(PATH + "/stream/{id}/{path}", userId, videoPath)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).streamVideo(videoPath, userId);
    }

    @Test
    void findRecommendedVideosByUserId() throws Exception {
        long userId = 1L;
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        when(videoUseCases.findRecommendedVideos(anyLong())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = mvc.perform(
                get(PATH + "/recommended/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findRecommendedVideos(anyLong());
    }

    @Test
    void findLikedVideosByUserId() throws Exception {
        long userId = 1L;
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        when(videoUseCases.findUserInteractedVideos(anyLong(), any())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = mvc.perform(
                get(PATH + "/liked/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findUserInteractedVideos(anyLong(), any());
    }

    @Test
    void findDislikedVideosByUserId() throws Exception {
        long userId = 1L;
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        when(videoUseCases.findUserInteractedVideos(anyLong(), any())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = mvc.perform(
                get(PATH + "/disliked/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findUserInteractedVideos(anyLong(), any());
    }

    @Test
    void findUserLastViewedVideosByUserId() throws Exception {
        long userId = 1L;
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        when(videoUseCases.findLastViewedVideos(anyLong())).thenReturn(List.of(VideoFixture.newVideo()));

        var result = mvc.perform(
                get(PATH + "/last-viewed/{id}", userId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).findLastViewedVideos(anyLong());
    }

    @Test
    void likeVideo() throws Exception {
        long userId = 1L;
        long videoId = 1L;

        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        doNothing().when(videoUseCases).likeVideo(anyLong(), anyLong());

        var result = mvc.perform(
                post(PATH + "/like/{userId}/{videoId}", userId, videoId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).likeVideo(anyLong(), anyLong());
    }

    @Test
    void dislikeVideo() throws Exception {
        long userId = 1L;
        long videoId = 1L;

        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        doNothing().when(videoUseCases).dislikeVideo(anyLong(), anyLong());

        var result = mvc.perform(
                post(PATH + "/dislike/{userId}/{videoId}", userId, videoId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).dislikeVideo(anyLong(), anyLong());
    }

    @Test
    void uploadVideoShouldRunAsExpected() throws Exception {
        long userId = 1L;
        CreateVideoRequestDTO requestDTO = CreateVideoRequestDTOFixture.newRequest();
        when(userUseCases.findById(userId)).thenReturn(UserFixture.newUser());
        when(videoUseCases.uploadVideo(any())).thenReturn(VideoFixture.newVideo());
        var fileTest = new MockMultipartFile("data",
                "filename.mp4", "video/mp4", "file1".getBytes());

        var result = mvc.perform(
                multipart(PATH + "/{id}", userId)
                        .file("video", fileTest.getBytes())
                        .param("videoName", requestDTO.getVideoName())
                        .param("videoDescription", requestDTO.getVideoDescription())
                        .param("categoryIds", requestDTO.getCategoryIds().get(0).toString())
                        .contentType(MediaType.MULTIPART_FORM_DATA_VALUE)
        ).andExpect(status().isOk());

        verify(userUseCases, times(1)).findById(userId);
        verify(videoUseCases, times(1)).uploadVideo(any());
    }

    @Test
    void deleteVideo() throws Exception {
        long userId = 1L;
        long videoId = 1L;

        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        doNothing().when(videoUseCases).deleteVideo(anyLong(), anyLong());

        var result = mvc.perform(
                delete(PATH + "/{userId}/{videoId}", userId, videoId)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk());

        verify(videoUseCases, times(1)).deleteVideo(anyLong(), anyLong());
    }
}