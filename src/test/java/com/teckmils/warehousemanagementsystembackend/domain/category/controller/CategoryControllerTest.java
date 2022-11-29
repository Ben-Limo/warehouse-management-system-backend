package com.teckmils.warehousemanagementsystembackend.domain.category.controller;

import com.teckmils.warehousemanagementsystembackend.domain.category.dto.CategoryItemDTO;
import com.teckmils.warehousemanagementsystembackend.domain.category.model.Category;
import com.teckmils.warehousemanagementsystembackend.domain.category.service.CategoryNotFoundException;
import com.teckmils.warehousemanagementsystembackend.domain.category.service.CategoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Timestamp;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService categoryService;

    @Test
    void getCategoryById_returnSavedCategory() throws Exception {
        // given
        given(categoryService.getCategoryById(anyLong())).willReturn(
                CategoryItemDTO.builder()
                        .id(4434L)
                        .name("mainframe")
                        .description("lorem ipsum test")
                        .createdAt(Timestamp.valueOf("2022-01-02 10:16:33.734"))
                        .updatedAt(Timestamp.valueOf("2022-01-02 10:16:33.734"))
                        .build()
        );
        // when // then
        mockMvc.perform(get("/api/categories/4434"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(4434))
                .andExpect(jsonPath("name").value("mainframe"))
                .andExpect(jsonPath("description").value("lorem ipsum test"));


    }

    @Test
    void getCategory_forMissingCategory_returnStatus404() throws Exception {
        // given
        given(categoryService.getCategoryById(anyLong())).willThrow(CategoryNotFoundException.class);

        // when // then
        mockMvc.perform(get("/api/categories/6"))
                .andExpect(status().isNotFound());
    }
}