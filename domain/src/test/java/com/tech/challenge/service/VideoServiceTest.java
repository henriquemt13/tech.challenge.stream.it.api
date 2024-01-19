package com.tech.challenge.service;

import com.tech.challenge.dto.CreateVideoDTO;
import com.tech.challenge.dto.SearchVideoDTO;
import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.fixture.VideoFixture;
import com.tech.challenge.persistence.VideoPersistence;
import com.tech.challenge.service.impl.VideoServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VideoServiceTest {

    @InjectMocks
    private VideoServiceImpl service;

    @Mock
    private VideoPersistence persistence;

    @Mock
    private VideoCategoriesService videoCategoriesService;

    @Test
    void uploadShouldRunAsExpected() throws IOException {
        var uploadResult = VideoFixture.newVideo();
        when(persistence.save(any(), any())).thenReturn(uploadResult);

        var result = service.upload(new CreateVideoDTO());

        verify(persistence, times(1)).save(any(), any());
        verify(videoCategoriesService, times(1)).save(anyLong(), any());
        assertEquals(result, uploadResult);
    }

    @Test
    void deleteShouldRunAsExpected() throws IOException {
        when(service.findById(anyLong())).thenReturn(Optional.of(VideoFixture.newVideo()));
        doNothing().when(persistence).delete(any());

        assertDoesNotThrow(() -> service.delete(1L, 1L));
    }

    @Test
    void deleteShouldThrowBadRequestException() throws IOException {
        when(persistence.findById(anyLong())).thenReturn(Optional.of(VideoFixture.newVideo()));
        doThrow(IOException.class).when(persistence).delete(any());

        assertThrows(BadRequestException.class, () -> service.delete(1L, 1L));
    }

    @Test
    void deleteShouldThrowBadRequestExceptionByDifferentIds() {
        var video = VideoFixture.newVideo();
        video.setUploaderUserId(2L);
        when(persistence.findById(anyLong())).thenReturn(Optional.of(video));

        assertThrows(BadRequestException.class, () -> service.delete(1L, 1L));
    }

    @Test
    void deleteShouldThrowNotFoundException() {
        when(persistence.findById(anyLong())).thenReturn(Optional.empty());


        assertThrows(NotFoundException.class, () -> service.delete(1L, 1L));
    }


    @Test
    void findByIdShouldRunAsExpected() {
        when(persistence.findById(anyLong())).thenReturn(Optional.empty());

        var result = service.findById(1L);

        assertEquals(result, Optional.empty());
    }

    @Test
    void findByIdInShouldRUnAsExpected() {
        when(persistence.findByIdIn(any())).thenReturn(List.of(VideoFixture.newVideo()));
        var result = service.findByIdIn(List.of(1L));

        assertEquals(result, List.of(VideoFixture.newVideo()));
    }

    @Test
    void findRecommendedVideosByUserIdShouldRunAsExpected() {
        when(persistence.findRecommendedVideosByUserId(any())).thenReturn(List.of(VideoFixture.newVideo()));
        var result = service.findRecommendedVideosByUserId(1L);

        assertEquals(result, List.of(VideoFixture.newVideo()));
    }

    @Test
    void findByVideoPath() {
        when(persistence.findByVideoPath(any())).thenReturn(Optional.of(VideoFixture.newVideo()));
        var result = service.findByVideoPath("url/test");

        assertEquals(result, Optional.of(VideoFixture.newVideo()));
    }

    @Test
    void findAllShouldRunAsExpected() {
        when(persistence.findAll(any())).thenReturn(VideoFixture.newVideoResult());

        var result = service.findAll(new SearchVideoDTO());

        assertEquals(result, VideoFixture.newVideoResult());
    }

    @Test
    void findByIdInShouldRunAsExpected() {
        when(persistence.findByIdIn(any(), any())).thenReturn(VideoFixture.newVideoResult());

        var result = service.findByIdIn(List.of(1L), new SearchVideoDTO());

        assertEquals(result, VideoFixture.newVideoResult());
    }

    @Test
    void findTotalVideosShouldRunAsExpected() {
        when(persistence.totalVideos()).thenReturn(1L);

        var result = service.findTotalVideos();

        assertEquals(result, 1L);
    }
}