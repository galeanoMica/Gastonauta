package com.example.gastonauta.services;

import com.example.gastonauta.DTO.LoginDTO;
import com.example.gastonauta.DTO.RegistroDTO;
import com.example.gastonauta.models.Usuario;
import com.example.gastonauta.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> validarLogin(LoginDTO dto) {
        return usuarioRepository.findByEmailAndPassword(dto.getEmail(), dto.getPassword());
    }

    public Usuario registrarNuevoUsuario(RegistroDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setMonedaBase(dto.getMonedaBase());

        return usuarioRepository.save(usuario);
    }
}