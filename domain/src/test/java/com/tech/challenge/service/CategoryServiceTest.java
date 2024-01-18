package com.tech.challenge.service;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.fixture.CategoryFixture;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.persistence.CategoryPersistence;
import com.tech.challenge.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl service;

    @Mock
    private CategoryPersistence persistence;

    @Mock
    private UserCategoriesService userCategoriesService;

    @Test
    void likeCategoryShouldRunAsExpected() {

        when(userCategoriesService.save(anyLong(), anyLong()))
                .thenReturn(new UserCategories());

        service.likeCategory(1L, 1L);

        verify(userCategoriesService, times(1))
                .save(anyLong(), anyLong());
    }

    @Test
    void likeCategoryThrowsBadRequestException() {
        when(userCategoriesService.save(anyLong(), anyLong()))
                .thenThrow(BadRequestException.class);

        assertThrows(BadRequestException.class, () -> service.likeCategory(1L, 1L));
    }

    @Test
    void findAllShouldRunAsExpected() {
        when(persistence.findAll()).thenReturn(List.of(CategoryFixture.newCategory()));

        var result = service.findAll();

        verify(persistence, times(1)).findAll();
        assertEquals(result, List.of(CategoryFixture.newCategory()));

    }

    @Test
    void findByIdShouldRunAsExpected() {
        when(persistence.findById(anyLong()))
                .thenReturn(Optional.of(CategoryFixture.newCategory()));

        var result = service.findById(1L);

        verify(persistence, times(1)).findById(anyLong());
        assertEquals(CategoryFixture.newCategory(), result.get());
    }

    @Test
    void findByIdInRunAsExpected() {
        when(persistence.findByIdIn(any()))
                .thenReturn(List.of(CategoryFixture.newCategory()));

        var result = service.findByIdIn(List.of(1L));

        verify(persistence, times(1)).findByIdIn(any());
        assertEquals(List.of(CategoryFixture.newCategory()), result);
    }

}