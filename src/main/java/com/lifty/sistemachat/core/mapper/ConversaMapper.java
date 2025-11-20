package com.lifty.sistemachat.core.mapper;

import com.lifty.sistemachat.api.dto.conversa.ConversaResponseDTO;
import com.lifty.sistemachat.domain.model.Conversa;
import org.springframework.stereotype.Component;

@Component
public class ConversaMapper {

    public ConversaResponseDTO toResponseDTO(Conversa conversa) {
        return new ConversaResponseDTO(
                conversa.getId(),
                conversa.getRemetente(),
                conversa.getDestinatario(),
                conversa.getMensagems(),
                conversa.getCriadaEm());
    }
}
