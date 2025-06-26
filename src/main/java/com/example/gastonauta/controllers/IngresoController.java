package com.example.gastonauta.controllers;

import com.example.gastonauta.DTO.IngresoDTO;
import com.example.gastonauta.models.Ingreso;
import com.example.gastonauta.services.IngresoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ingresos")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class IngresoController {

    @Autowired
    private IngresoService ingresoService;

    
    @GetMapping
    public List<Ingreso> getAllIngresos() {
        return ingresoService.obtenerTodos();
    }

    
    @PostMapping
    public Ingreso crearIngreso(@RequestBody IngresoDTO ingresoDTO) {
        return ingresoService.crearIngresoDesdeDTO(ingresoDTO);
    }

    @PatchMapping("/{id}")
    public Ingreso actualizarIngreso(@PathVariable Long id, @RequestBody IngresoDTO dto) {
        return ingresoService.actualizarIngresoDesdeDTO(id, dto);
    }

   @DeleteMapping("/{id}")
    public void eliminarIngreso(@PathVariable Long id) {
        ingresoService.eliminarIngresoPorId(id);
    }
   
}