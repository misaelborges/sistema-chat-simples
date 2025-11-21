package com.lifty.sistemachat.domain.service;

import com.lifty.sistemachat.api.dto.mensagem.MensagemRequestDTO;
import com.lifty.sistemachat.api.dto.mensagem.MensagemResponseDTO;
import com.lifty.sistemachat.api.dto.mensagem.MensagensResponseDTO;
import com.lifty.sistemachat.core.mapper.MensagemMapper;
import com.lifty.sistemachat.domain.model.Conversa;
import com.lifty.sistemachat.domain.model.Mensagem;
import com.lifty.sistemachat.domain.model.User;
import com.lifty.sistemachat.domain.repository.ConversaRepository;
import com.lifty.sistemachat.domain.repository.MensagemRepository;
import com.lifty.sistemachat.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MensagemService {
    
    private final MensagemRepository mensagemRepository;
    private final ConversaRepository conversaRepository;
    private final MensagemMapper mensagemMapper;
    private final UserRepository userRepository;

    public MensagemService(MensagemRepository mensagemRepository, ConversaRepository conversaRepository,
                           MensagemMapper mensagemMapper, UserRepository userRepository) {
        this.mensagemRepository = mensagemRepository;
        this.conversaRepository = conversaRepository;
        this.mensagemMapper = mensagemMapper;
        this.userRepository = userRepository;
    }

    public MensagemResponseDTO enviarMensagem(MensagemRequestDTO mensagemRequestDTO) {
        Conversa conversa = buscarConversa(mensagemRequestDTO.conversaId());
        User remetente = buscaUser(mensagemRequestDTO.remetenteId());

        Mensagem mensagem = mensagemMapper.toEntity(mensagemRequestDTO, conversa, remetente);

        mensagem = mensagemRepository.save(mensagem);

        MensagemResponseDTO mensagemResponseDTO = mensagemMapper.mensagemResponseDTO(mensagem);
        return mensagemResponseDTO;
    }


    public List<MensagensResponseDTO> listarMensagemConversa(Long id) {
        buscarConversa(id);
        List<Mensagem> mensagens = mensagemRepository.findByConversaIdOrderByDataHoraAsc(id);

        List<MensagensResponseDTO> mensagensResponseDTOS = mensagens.stream()
                .map(mensagemMapper::toMensagensResponseDTO)
                .toList();

        return mensagensResponseDTOS;
    }

    private Conversa buscarConversa(Long id) {
        return conversaRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Não existe uma conversa com o id: %d", id)));
    }

    private User buscaUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Não existe um usuario com o id: %d", id)));
    }
}
