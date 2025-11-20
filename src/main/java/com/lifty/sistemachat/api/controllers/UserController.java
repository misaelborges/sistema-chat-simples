package com.lifty.sistemachat.api.controllers;

import com.lifty.sistemachat.api.dto.user.UserRequestDTO;
import com.lifty.sistemachat.api.dto.user.UserResponseDTO;
import com.lifty.sistemachat.domain.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<UserResponseDTO> salvarUsuario(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.salvarUsuario(userRequestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);

    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> listarUsusario() {
        List<UserResponseDTO> userResponseDTOS = userService.listarUsuarios();
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTOS);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDTO> atualizarUsuario(@PathVariable Long id, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        UserResponseDTO userResponseDTO = userService.atualizarUsuario(id, userRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);

    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<UserResponseDTO> buscarUserPorId(@PathVariable Long id) {
        UserResponseDTO userResponseDTO = userService.buscarUserPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarUsuario(@PathVariable Long id) {
        userService.deletarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
