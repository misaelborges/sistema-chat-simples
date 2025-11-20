package com.lifty.sistemachat.api.dto.user;

import jakarta.validation.constraints.NotBlank;

public record UserRequestDTO(
        @NotBlank(message = "Nome do usuario não pode ser em branco")
        String nome) {
}
