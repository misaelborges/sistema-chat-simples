package com.lifty.sistemachat.api.dto.mensagem;

import java.time.LocalDateTime;

public record MensagemResponseDTO(
        String remetente,
        String destinatario,
        String msg,
        LocalDateTime dataHora) {
}
