package com.lifty.sistemachat.api.dto.mensagem;

import java.time.LocalDateTime;

public record MensagensResponseDTO(
        String remetente,
        String destinatario,
        String msg,
        LocalDateTime dataHora) {

}
