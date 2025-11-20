package com.lifty.sistemachat.api.dto.conversa;

import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.domain.model.Mensagem;

import java.time.LocalTime;
import java.util.List;

public record ConversaResponseDTO(
        Long id,
        UserResponseDTO remetente,
        UserResponseDTO destinatario,
        List<Mensagem> mensagems,
        LocalTime criadaEm
) {
}
