package com.example.gastonauta.controllers;

import com.example.gastonauta.DTO.LoginDTO;
import com.example.gastonauta.DTO.RegistroDTO;
import com.example.gastonauta.models.Usuario;
import com.example.gastonauta.services.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        Optional<Usuario> usuarioOpt = usuarioService.validarLogin(loginDTO);
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registrar(@RequestBody RegistroDTO registroDTO) {
        Usuario nuevo = usuarioService.registrarNuevoUsuario(registroDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }
}