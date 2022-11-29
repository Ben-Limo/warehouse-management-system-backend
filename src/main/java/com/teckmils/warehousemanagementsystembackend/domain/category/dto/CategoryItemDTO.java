package com.teckmils.warehousemanagementsystembackend.domain.category.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.UUID;
@Builder
public record CategoryItemDTO(
        @NotNull Long id,
        @NotBlank String name,
        @NotBlank String description,
        Timestamp createdAt,
        Timestamp updatedAt
) {
}
