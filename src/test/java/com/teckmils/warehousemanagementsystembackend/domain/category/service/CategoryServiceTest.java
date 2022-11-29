package com.teckmils.warehousemanagementsystembackend.domain.category.service;

import com.teckmils.warehousemanagementsystembackend.domain.category.dto.CategoryItemDTO;
import com.teckmils.warehousemanagementsystembackend.domain.category.model.Category;
import com.teckmils.warehousemanagementsystembackend.domain.category.repository.CategoryRepository;
import org.assertj.core.api.BDDAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.BDDAssertions.then;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@Transactional
class CategoryServiceTest {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private  CategoryService categoryService;

    @DisplayName("Returns saved Category from service layer")
    @Test
    void getCategoryById_returnSavedCategory() {
        // given
        Category savedCategory = categoryRepository.save(new Category("Server", "Lorem ipsum dolor sit amet, consectetur adipiscing elit."));

        // when
        CategoryItemDTO category = categoryService.getCategoryById(savedCategory.getId());

        // then
        then(category.name()).isEqualTo(savedCategory.getName());
        then(category.id()).isNotNull();
    }

    @Test
    void getCategoryById_whenMissingCategory_notFoundExceptionThrown() {
        // given
        Long id = 233L;

        // when
        Throwable throwable = catchThrowable(() -> categoryService.getCategoryById(id));

        // then
        BDDAssertions.then(throwable).isInstanceOf(CategoryNotFoundException.class);
    }
}
