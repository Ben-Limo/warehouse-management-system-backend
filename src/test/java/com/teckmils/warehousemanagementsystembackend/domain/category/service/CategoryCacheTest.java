package com.teckmils.warehousemanagementsystembackend.domain.category.service;

import com.teckmils.warehousemanagementsystembackend.domain.category.model.Category;
import com.teckmils.warehousemanagementsystembackend.domain.category.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.times;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class CategoryCacheTest {
    @Autowired
    private CategoryService categoryService;

    @MockBean
    private CategoryRepository categoryRepository;

    @Test
    void testGetCategoryById_forMultipleRequests_retrievesFromCache() {
        // given
        Long id = 4323L;
        given(categoryRepository.findById(id)).willReturn(Optional.of(new Category(id, "mainframe", "lorem ipsum test")));

        // when
        categoryService.getCategoryById(id);
        categoryService.getCategoryById(id);
        categoryService.getCategoryById(id);

        // then
        then(categoryRepository).should(times(1)).findById(id);

    }
}
