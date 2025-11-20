package com.lifty.sistemachat.domain.service;

import com.lifty.sistemachat.domain.repositorie.ConversaRepository;
import org.springframework.stereotype.Service;

@Service
public class ConversaService {

    private final ConversaRepository conversaRepository;

    public ConversaService(ConversaRepository conversaRepository) {
        this.conversaRepository = conversaRepository;
    }
}
