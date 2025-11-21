package com.lifty.sistemachat.api.dto.conversa;

import com.lifty.sistemachat.api.dto.user.UserResponseDTO;

import java.time.LocalTime;

public record ConversaResponseDTO(
        Long id,
        UserResponseDTO remetente,
        UserResponseDTO destinatario,
        LocalTime criadaEm
) {
}
