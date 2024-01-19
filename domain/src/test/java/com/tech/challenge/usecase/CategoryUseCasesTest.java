package com.tech.challenge.usecase;

import com.tech.challenge.exception.BadRequestException;
import com.tech.challenge.exception.NotFoundException;
import com.tech.challenge.fixture.CategoryFixture;
import com.tech.challenge.fixture.UserCategoriesFixture;
import com.tech.challenge.fixture.UserFixture;
import com.tech.challenge.fixture.VideoCategoriesFixture;
import com.tech.challenge.model.Category;
import com.tech.challenge.model.UserCategories;
import com.tech.challenge.model.VideoCategories;
import com.tech.challenge.service.CategoryService;
import com.tech.challenge.service.UserCategoriesService;
import com.tech.challenge.service.VideoCategoriesService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryUseCasesTest {

    @InjectMocks
    private CategoryUseCases useCases;

    @Mock
    private UserUseCases userUseCases;

    @Mock
    private VideoCategoriesService videoCategoriesService;

    @Mock
    private UserCategoriesService userCategoriesService;

    @Mock
    private CategoryService categoryService;


    @Test
    void findUserLikedCategoriesShouldRunAsExpected() {
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());
        when(userCategoriesService.findByUserId(anyLong())).thenReturn(List.of(UserCategoriesFixture.newUserCategoriesFixture()));
        when(categoryService.findByIdIn(any())).thenReturn(List.of(CategoryFixture.newCategory()));

        assertEquals(List.of(CategoryFixture.newCategory()), useCases.findUserLikedCategories(1L));
    }

    @Test
    void findUserLikedCategoriesShouldThrowNotFoundException() {
        when(userUseCases.findById(anyLong())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> useCases.findUserLikedCategories(1L));
    }

    @Test
    void likeCategoriesShouldRunAsExpected() {
        when(userUseCases.findById(anyLong())).thenReturn(UserFixture.newUser());

        assertDoesNotThrow(() -> useCases.likeCategories(1L, List.of(1L)));
    }

    @Test
    void likeCategoriesShouldThrowNotFoundException() {
        when(userUseCases.findById(anyLong())).thenThrow(NotFoundException.class);

        assertThrows(NotFoundException.class, () -> useCases.likeCategories(1L, List.of(1L)));
    }

    @Test
    void findAll() {
        when(categoryService.findAll()).thenReturn(List.of(CategoryFixture.newCategory()));

        var categories = useCases.findAll();

        assertEquals(categories, List.of(CategoryFixture.newCategory()));
    }

    @Test
    void findByVideoId() {
        when(videoCategoriesService.findByVideoId(anyLong())).thenReturn(List.of(VideoCategoriesFixture.newVideoCategories()));
        when(categoryService.findByIdIn(any())).thenReturn(List.of(CategoryFixture.newCategory()));
        var categories = useCases.findByVideoId(1L);

        assertEquals(categories, List.of(CategoryFixture.newCategory()));
    }
}