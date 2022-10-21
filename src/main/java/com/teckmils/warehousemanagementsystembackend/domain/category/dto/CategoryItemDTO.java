package com.teckmils.warehousemanagementsystembackend.domain.category.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;

public record CategoryItemDTO(
        @NotNull UUID id,
        @NotBlank String name,
        @NotBlank String description,
        Timestamp createdAt,
        Timestamp updatedAt
) {
}
