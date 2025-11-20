package com.lifty.sistemachat.domain.service;

import com.lifty.sistemachat.domain.repositorie.MensagemRepository;
import org.springframework.stereotype.Service;

@Service
public class MensagemService {
    
    private final MensagemRepository mensagemRepository;

    public MensagemService(MensagemRepository mensagemRepository) {
        this.mensagemRepository = mensagemRepository;
    }
}
