package com.example.gastonauta.controllers;

import com.example.gastonauta.DTO.GastoDTO;
import com.example.gastonauta.models.Gasto;
import com.example.gastonauta.services.GastoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @GetMapping
    public List<Gasto> getAllGastos() {
        return gastoService.obtenerTodos();
    }

   
    @PostMapping
    public Gasto crearGasto(@RequestBody GastoDTO gastoDTO) {
        return gastoService.crearGastoDesdeDTO(gastoDTO);
    }

    @PatchMapping("/{id}")
    public Gasto actualizarGasto(@PathVariable Long id, @RequestBody GastoDTO dto) {
        return gastoService.actualizarGastoDesdeDTO(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminarGasto(@PathVariable Long id) {
        gastoService.eliminarGastoPorId(id);
    }
}