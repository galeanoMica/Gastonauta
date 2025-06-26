package com.example.gastonauta.controllers;

import com.example.gastonauta.models.Categoria;
import com.example.gastonauta.models.TipoCategoria;
import com.example.gastonauta.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // GET /categorias?tipo=GASTO 
    @GetMapping(params = "tipo")
    public List<Categoria> getCategoriasPorTipo(@RequestParam TipoCategoria tipo) {
        return categoriaRepository.findByTipo(tipo);
    }

    
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}