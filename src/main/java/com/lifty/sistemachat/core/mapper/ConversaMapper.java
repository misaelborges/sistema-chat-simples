package com.lifty.sistemachat.core.mapper;

import com.lifty.sistemachat.api.dto.conversa.ConversaResponseDTO;
import com.lifty.sistemachat.api.dto.conversa.ConversaResponseResumoDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseResumoDTO;
import com.lifty.sistemachat.domain.model.Conversa;
import org.springframework.stereotype.Component;

@Component
public class ConversaMapper {

    public ConversaResponseDTO toResponseDTO(Conversa conversa) {
        return new ConversaResponseDTO(
                conversa.getId(),
                new UserResponseDTO(conversa.getRemetente().getId(), conversa.getRemetente().getNome()),
                new UserResponseDTO(conversa.getDestinatario().getId(), conversa.getDestinatario().getNome()),
                conversa.getMensagems(),
                conversa.getCriadaEm());
    }
}
