package com.example.gastonauta.services;

import com.example.gastonauta.DTO.GastoDTO;
import com.example.gastonauta.models.Categoria;
import com.example.gastonauta.models.Gasto;
import com.example.gastonauta.models.Usuario;
import com.example.gastonauta.repositories.CategoriaRepository;
import com.example.gastonauta.repositories.GastoRepository;
import com.example.gastonauta.repositories.UsuarioRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GastoService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Gasto> obtenerTodos() {
        return gastoRepository.findAll();
    }
    public Gasto crearGastoDesdeDTO(GastoDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
            .orElseThrow(() -> new RuntimeException("Categoría no encontrada con ID: " + dto.getCategoriaId()));

        Gasto gasto = new Gasto();
        gasto.setMonto(dto.getMonto());
        gasto.setDescripcion(dto.getDescripcion());
        gasto.setFecha(dto.getFecha());
        gasto.setCategoria(categoria);
        Usuario usuario = usuarioRepository.findById(dto.getUsuarioId())
            .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        gasto.setUsuario(usuario);

        return gastoRepository.save(gasto);
    }
    public Gasto actualizarGastoDesdeDTO(Long id, GastoDTO dto) {
        Gasto gasto = gastoRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("gasto no encontrado con ID: " + id));

        gasto.setMonto(dto.getMonto());
        gasto.setDescripcion(dto.getDescripcion());
        gasto.setFecha(dto.getFecha());

        if (dto.getCategoriaId() != null) {
            Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));
            gasto.setCategoria(categoria);
        }

        return gastoRepository.save(gasto);
    }
     public void eliminarGastoPorId(Long id) {
        gastoRepository.deleteById(id);
    }
}