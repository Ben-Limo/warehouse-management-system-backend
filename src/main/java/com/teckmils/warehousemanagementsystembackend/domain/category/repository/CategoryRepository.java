package com.teckmils.warehousemanagementsystembackend.domain.category.repository;

import com.teckmils.warehousemanagementsystembackend.domain.category.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long Id);

    List<Category> findAll();

    void deleteById(@NonNull Long id);

    Category getCategoryByName(String name);

}
