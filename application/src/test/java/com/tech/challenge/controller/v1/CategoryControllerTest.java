package com.tech.challenge.controller.v1;

import com.tech.challenge.config.TestConfig;
import com.tech.challenge.fixture.CategoryFixture;
import com.tech.challenge.mapper.CategoryMapper;
import com.tech.challenge.service.CategoryService;
import com.tech.challenge.service.UserCategoriesService;
import com.tech.challenge.service.VideoCategoriesService;
import com.tech.challenge.usecase.CategoryUseCases;
import com.tech.challenge.usecase.UserUseCases;
import com.tech.challenge.utils.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
 import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CategoryController.class)
@Import({CategoryController.class})
@ContextConfiguration(classes = TestConfig.class)
class CategoryControllerTest {

    private static final String PATH = "/category";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CategoryMapper mapper;

    @MockBean
    private CategoryUseCases categoryUseCases;

    @MockBean
    private CategoryService categoryService;

    @BeforeEach
    void setupMockMvc() {
        this.mvc = MockMvcBuilders
                .standaloneSetup(new CategoryController(mapper, categoryUseCases))
                .addFilter(((request, response, chain) -> {
                    response.setCharacterEncoding("UTF-8");
                    chain.doFilter(request, response);
                })).build();
    }


    @Test
    void findAllShouldRunAsExpected() throws Exception {
        when(categoryUseCases.findAll()).thenReturn(List.of(CategoryFixture.newCategory()));

        var result = mvc.perform(
                get(PATH)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk()).andReturn();

        verify(categoryUseCases, times(1)).findAll();
    }

    @Test
    void findByVideoIdShouldRunAsExpected() throws Exception {
        long id = 1L;
        when(categoryUseCases.findByVideoId(anyLong())).thenReturn(List.of(CategoryFixture.newCategory()));

        var result = mvc.perform(
                get(PATH + "/video/" + id)
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk()).andReturn();

        verify(categoryUseCases, times(1)).findByVideoId(anyLong());
    }

    @Test
    void findLikedCategoriesShouldRunAsExpected() throws Exception {
        long id = 1L;
        when(categoryUseCases.findUserLikedCategories(anyLong())).thenReturn(List.of(CategoryFixture.newCategory()));

        var result = mvc.perform(
                get(PATH + "/user/" + id +"/like-categories")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk()).andReturn();

        verify(categoryUseCases, times(1)).findUserLikedCategories(anyLong());
    }

    @Test
    void likeCategoriesShouldRunAsExpected() throws Exception {
        long id = 1L;
        doNothing().when(categoryUseCases).likeCategories(anyLong(), anyList());
        mvc.perform(
                post(PATH +  "/user/" + id + "/like-categories")
                        .param("categoryId", "1")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk()).andReturn();

        verify(categoryUseCases, times(1)).likeCategories(anyLong(), anyList());
    }
}