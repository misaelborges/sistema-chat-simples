package com.lifty.sistemachat.api.controllers;

import com.lifty.sistemachat.api.dto.user.UserRequestDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponseDTO salvarUsuario(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.salvarUsuario(userRequestDTO);
        return userResponseDTO;

    }

    @GetMapping
    public List<UserResponseDTO> listarUsusario() {
        List<UserResponseDTO> userResponseDTOS = userService.listarUsuarios();
        return userResponseDTOS;
    }
}
