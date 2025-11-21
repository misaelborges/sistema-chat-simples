package com.lifty.sistemachat.domain.service;


import com.lifty.sistemachat.api.dto.conversa.ConversaRequestDTO;
import com.lifty.sistemachat.api.dto.conversa.ConversaResponseDTO;
import com.lifty.sistemachat.api.dto.conversa.ConversaResponseResumoDTO;
import com.lifty.sistemachat.core.mapper.ConversaMapper;
import com.lifty.sistemachat.domain.model.Conversa;
import com.lifty.sistemachat.domain.model.User;
import com.lifty.sistemachat.domain.repository.ConversaRepository;
import com.lifty.sistemachat.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConversaService {

    private final ConversaRepository conversaRepository;
    private final UserRepository userRepository;
    private final ConversaMapper conversaMapper;

    public ConversaService(ConversaRepository conversaRepository, ConversaMapper conversaMapper, UserRepository userRepository) {
        this.conversaRepository = conversaRepository;
        this.conversaMapper = conversaMapper;
        this.userRepository = userRepository;
    }

    public ConversaResponseDTO criarConversa(ConversaRequestDTO conversaRequestDTO) {
        Conversa conversa;
        User remetente = buscaUser(conversaRequestDTO.remetente());
        User destinatario = buscaUser(conversaRequestDTO.destinatario());

        Optional<Conversa> conversaUsuarios = conversaRepository.findConversaEntreUsuarios(remetente.getId(), destinatario.getId());

        if (conversaUsuarios.isEmpty()) {
            conversa = new Conversa();
            conversa.setRemetente(remetente);
            conversa.setDestinatario(destinatario);
            conversa = conversaRepository.save(conversa);
            return conversaMapper.toResponseDTO(conversa);
        }

        return conversaMapper.toResponseDTO(conversaUsuarios.get());
    }

    public List<ConversaResponseResumoDTO> listarConversas() {
        List<Conversa> conversas = conversaRepository.findAll();
        List<ConversaResponseResumoDTO> conversaResponseResumoDTOS = conversas.stream()
                .map(conversaMapper::toResponseResumoDTO)
                .toList();

        return conversaResponseResumoDTOS;
    }

    private User buscaUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Usuario com %d não existe", id)));
    }
}
