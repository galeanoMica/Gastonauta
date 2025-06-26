package com.example.gastonauta.services;

import com.example.gastonauta.DTO.IngresoDTO;
import com.example.gastonauta.models.Categoria;
import com.example.gastonauta.models.Ingreso;
import com.example.gastonauta.models.Usuario;
import com.example.gastonauta.repositories.CategoriaRepository;
import com.example.gastonauta.repositories.IngresoRepository;
import com.example.gastonauta.repositories.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngresoService {

    @Autowired
    private IngresoRepository ingresoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Ingreso crearIngresoDesdeDTO(IngresoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + dto.getCategoriaId()));

        Ingreso ingreso = new Ingreso();
        ingreso.setMonto(dto.getMonto());
        ingreso.setDescripcion(dto.getDescripcion());
        ingreso.setFecha(dto.getFecha());
        ingreso.setCategoria(categoria);
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
        .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        ingreso.setUsuario(usuario);

        return ingresoRepository.save(ingreso);
    }

    public java.util.List<Ingreso> obtenerTodos() {
        return ingresoRepository.findAll();
    }

    public Ingreso actualizarIngresoDesdeDTO(Long id, IngresoDTO dto) {
        Ingreso ingreso = ingresoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Ingreso no encontrado con ID: " + id));

        ingreso.setMonto(dto.getMonto());
        ingreso.setDescripcion(dto.getDescripcion());
        ingreso.setFecha(dto.getFecha());

        if (dto.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            ingreso.setCategoria(categoria);
        }

        return ingresoRepository.save(ingreso);
    }

    public void eliminarIngresoPorId(Long id) {
        ingresoRepository.deleteById(id);
    }
}