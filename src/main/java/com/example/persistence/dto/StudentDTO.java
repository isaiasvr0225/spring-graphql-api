package com.example.persistence.dto;

import lombok.Builder;

import java.io.Serializable;
@Builder
public record StudentDTO(
        Long id,
        String name,
        Integer age,
        String email,
        Integer phone
) implements Serializable {
}
