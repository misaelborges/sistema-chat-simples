package com.lifty.sistemachat.api.dto.mensagem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record MensagemRequestDTO(
        @NotNull(message = "O ID da conversa é obrigatório")
        Long conversaId,

        @NotNull(message = "O ID do remetente é obrigatório")
        Long remetenteId,

        @NotBlank(message = "A mensagem não pode ser vazia")
        String msg
) {}