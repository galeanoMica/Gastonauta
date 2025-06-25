package com.example.gastonauta.controllers;

import com.example.gastonauta.DTO.IngresoDTO;
import com.example.gastonauta.models.Ingreso;
import com.example.gastonauta.services.IngresoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresos")
@CrossOrigin(origins = "*")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    // GET /ingresos → devuelve todos los ingresos
    @GetMapping
    public List<Ingreso> getAllIngresos() {
        return ingresoService.obtenerTodos();
    }

    // POST /ingresos → crea un ingreso desde DTO
    @PostMapping
    public Ingreso crearIngreso(@RequestBody IngresoDTO ingresoDTO) {
        return ingresoService.crearIngresoDesdeDTO(ingresoDTO);
    }
}