package com.lifty.sistemachat.domain.service;

import com.lifty.sistemachat.domain.repositorie.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
