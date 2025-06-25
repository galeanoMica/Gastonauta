package com.example.gastonauta.controllers;

import com.example.gastonauta.models.Categoria;
import com.example.gastonauta.models.TipoCategoria;
import com.example.gastonauta.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // GET /categorias → devuelve todas
    @GetMapping
    public List<Categoria> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    // GET /categorias?tipo=GASTO → devuelve solo las de tipo indicado
    @GetMapping(params = "tipo")
    public List<Categoria> getCategoriasPorTipo(@RequestParam TipoCategoria tipo) {
        return categoriaRepository.findByTipo(tipo);
    }

    // POST /categorias → para crear una nueva
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}