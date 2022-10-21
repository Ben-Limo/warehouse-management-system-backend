package com.teckmils.warehousemanagementsystembackend.domain.category.dto;

import javax.validation.constraints.NotBlank;

public record AddCategoryItem(@NotBlank String name, @NotBlank String description) {
}
