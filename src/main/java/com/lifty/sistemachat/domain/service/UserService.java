package com.lifty.sistemachat.domain.service;

import com.lifty.sistemachat.api.dto.user.UserRequestDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.core.openapi.mapper.UserMapper;
import com.lifty.sistemachat.domain.model.User;
import com.lifty.sistemachat.domain.repositorie.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public UserResponseDTO salvarUsuario(UserRequestDTO usuarioRequestDTO) {
        User user = userMapper.toEntity(usuarioRequestDTO);
        user = userRepository.save(user);
        return userMapper.toUserResponseDTO(user);
    }
}
