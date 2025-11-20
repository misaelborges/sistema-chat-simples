package com.lifty.sistemachat.api.dto.conversa;

import jakarta.validation.constraints.NotNull;

public record ConversaRequestDTO(
        @NotNull(message = "Remetente não pode ser em branco")
        Long remetente,

        @NotNull(message = "Destinatario não pode ser em branco")
        Long destinatario
) {
}
