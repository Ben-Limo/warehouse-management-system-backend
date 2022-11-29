package com.teckmils.warehousemanagementsystembackend.domain.category.service;

import com.teckmils.warehousemanagementsystembackend.domain.category.dto.AddCategoryItem;
import com.teckmils.warehousemanagementsystembackend.domain.category.dto.CategoryItemDTO;
import com.teckmils.warehousemanagementsystembackend.domain.category.model.Category;
import com.teckmils.warehousemanagementsystembackend.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<CategoryItemDTO> getCategories() {
        final List<Category> categories = this.categoryRepository.findAll();
        List<CategoryItemDTO> categoryItemDTOS = new ArrayList<>();
        categories.forEach(category -> categoryItemDTOS.add(new CategoryItemDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        )));
        return categoryItemDTOS;
    }

    @Cacheable("categories")
    public CategoryItemDTO getCategoryById(Long id) {
        final Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException());

        return new CategoryItemDTO(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getCreatedAt(),
                category.getUpdatedAt()
        );
    }

    public void addCategories(final Collection<AddCategoryItem> rawCategories) {
        rawCategories.forEach(rawCategory -> {
            final var category = new Category(rawCategory.name(), rawCategory.description());
            this.categoryRepository.save(category);
        });
    }

    public void deleteCategoryById(final Long id) {
        this.categoryRepository.deleteById(id);
    }
}
