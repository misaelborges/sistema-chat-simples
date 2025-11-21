package com.lifty.sistemachat.api.controllers;

import com.lifty.sistemachat.api.dto.conversa.ConversaRequestDTO;
import com.lifty.sistemachat.api.dto.conversa.ConversaResponseDTO;
import com.lifty.sistemachat.api.dto.conversa.ConversaResponseResumoDTO;
import com.lifty.sistemachat.domain.service.ConversaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conversas")
public class ConversaController {

    private final ConversaService conversaService;

    public ConversaController(ConversaService conversaService) {
        this.conversaService = conversaService;
    }

    @PostMapping
    public ResponseEntity<ConversaResponseDTO> criarConversa(@RequestBody @Valid ConversaRequestDTO conversaRequestDTO) {
        ConversaResponseDTO conversaResponseDTO = conversaService.criarConversa(conversaRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(conversaResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<ConversaResponseResumoDTO>> listarConversas() {
        List<ConversaResponseResumoDTO> conversaResponseResumoDTOS = conversaService.listarConversas();
        return ResponseEntity.status(HttpStatus.OK).body(conversaResponseResumoDTOS);
    }
}
