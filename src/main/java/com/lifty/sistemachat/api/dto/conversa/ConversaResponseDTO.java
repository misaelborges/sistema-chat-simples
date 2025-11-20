package com.lifty.sistemachat.api.dto.conversa;

import com.lifty.sistemachat.domain.model.Mensagem;
import com.lifty.sistemachat.domain.model.User;

import java.time.LocalTime;
import java.util.List;

public record ConversaResponseDTO(
        Long id,
        User remetente,
        User destinatario,
        List<Mensagem> mensagems,
        LocalTime criadaEm
) {
}
