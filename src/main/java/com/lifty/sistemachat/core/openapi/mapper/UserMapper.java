package com.lifty.sistemachat.core.openapi.mapper;

import com.lifty.sistemachat.api.dto.user.UserRequestDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toEntity(UserRequestDTO userRequestDTO) {
        if (userRequestDTO == null) throw new RuntimeException("UserRequestDTO null");
        return User.builder()
                .nome(userRequestDTO.nome())
                .build();
    }

    public UserResponseDTO toUserResponseDTO(User user) {
        if (user == null) throw new RuntimeException("user null");
        return new UserResponseDTO(user.getId(), user.getNome());
    }
}
