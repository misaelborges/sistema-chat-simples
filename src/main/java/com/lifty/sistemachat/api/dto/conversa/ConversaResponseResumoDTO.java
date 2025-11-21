package com.lifty.sistemachat.api.dto.conversa;


import com.lifty.sistemachat.api.dto.user.UserResponseResumoDTO;

public record ConversaResponseResumoDTO(
        Long id,
        UserResponseResumoDTO remetente,
        UserResponseResumoDTO destinatario
) {
}
