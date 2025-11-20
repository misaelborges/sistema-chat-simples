package com.lifty.sistemachat.api.dto.conversa;

import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseResumoDTO;
import com.lifty.sistemachat.domain.model.Mensagem;

import java.time.LocalTime;
import java.util.List;

public record ConversaResponseResumoDTO(
        Long id,
        UserResponseResumoDTO remetente,
        UserResponseResumoDTO destinatario
) {
}
