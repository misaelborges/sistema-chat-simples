package com.lifty.sistemachat.api.controllers;

import com.lifty.sistemachat.api.dto.mensagem.MensagemRequestDTO;
import com.lifty.sistemachat.api.dto.mensagem.MensagemResponseDTO;
import com.lifty.sistemachat.api.dto.mensagem.MensagensResponseDTO;
import com.lifty.sistemachat.domain.service.MensagemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mensagens")
public class MensagemController {

    private final MensagemService mensagemService;

    public MensagemController(MensagemService mensagemService) {
        this.mensagemService = mensagemService;
    }

    @PostMapping
    public ResponseEntity<MensagemResponseDTO> enviarMensagem(@RequestBody MensagemRequestDTO mensagemRequestDTO) {
        MensagemResponseDTO mensagemResponseDTO = mensagemService.enviarMensagem(mensagemRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mensagemResponseDTO);
    }

    @GetMapping("/conversas/{id}/mensagens")
    public ResponseEntity<List<MensagensResponseDTO>> listarMensagemConversa(@PathVariable Long id) {
        List<MensagensResponseDTO> mensagensResponseDTOS = mensagemService.listarMensagemConversa(id);
        return ResponseEntity.status(HttpStatus.OK).body(mensagensResponseDTOS);
    }
}
