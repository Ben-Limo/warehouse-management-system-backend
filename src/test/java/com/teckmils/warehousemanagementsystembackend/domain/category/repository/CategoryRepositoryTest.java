package com.teckmils.warehousemanagementsystembackend.domain.category.repository;

import com.teckmils.warehousemanagementsystembackend.domain.category.model.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import static org.assertj.core.api.BDDAssertions.then;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CategoryRepositoryTest {
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private TestEntityManager testEntityManager;
    @Test
    void testGetCategoryByName_returnsCategoryDetails() {
        //given
        Category savedCategory = testEntityManager.persistFlushFind(new Category("PC", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."));

        // when
        Category category = categoryRepository.getCategoryByName("PC");

        // then
        then(category.getId()).isNotNull();
        then(category.getName()).isEqualTo(savedCategory.getName());
    }

}