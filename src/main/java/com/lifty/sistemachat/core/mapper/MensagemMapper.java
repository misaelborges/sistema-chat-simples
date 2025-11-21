package com.lifty.sistemachat.core.mapper;

import com.lifty.sistemachat.api.dto.mensagem.MensagemRequestDTO;
import com.lifty.sistemachat.api.dto.mensagem.MensagemResponseDTO;
import com.lifty.sistemachat.api.dto.mensagem.MensagensResponseDTO;
import com.lifty.sistemachat.domain.model.Conversa;
import com.lifty.sistemachat.domain.model.Mensagem;
import com.lifty.sistemachat.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class MensagemMapper {

    public Mensagem toEntity(MensagemRequestDTO dto, Conversa conversa, User remetente) {
        User usuarioA = conversa.getRemetente();
        User usuarioB = conversa.getDestinatario();

        User destinatario = remetente.getId().equals(usuarioA.getId()) ? usuarioB : usuarioA;

        return Mensagem.builder()
                .conversa(conversa)
                .remetente(remetente)
                .destinatario(destinatario)
                .msg(dto.msg())
                .build();
    }

    public MensagemResponseDTO mensagemResponseDTO(Mensagem mensagem) {
        return new MensagemResponseDTO(
                mensagem.getRemetente().getNome(),
                mensagem.getDestinatario().getNome(),
                mensagem.getMsg(),
                mensagem.getDataHora());
    }

    public MensagensResponseDTO toMensagensResponseDTO(Mensagem mensagem) {
        return new MensagensResponseDTO(
                mensagem.getRemetente().getNome(),
                mensagem.getDestinatario().getNome(),
                mensagem.getMsg(),
                mensagem.getDataHora());
    }

}
