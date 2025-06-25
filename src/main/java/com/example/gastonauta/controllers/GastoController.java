package com.example.gastonauta.controllers;

import com.example.gastonauta.DTO.GastoDTO;
import com.example.gastonauta.models.Gasto;
import com.example.gastonauta.services.GastoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gastos")
@CrossOrigin(origins = "*")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    // GET /gastos → lista todos los gastos
    @GetMapping
    public List<Gasto> getAllGastos() {
        return gastoService.obtenerTodos();
    }

    // POST /gastos → crea nuevo gasto desde DTO
    @PostMapping
    public Gasto crearGasto(@RequestBody GastoDTO gastoDTO) {
        return gastoService.crearGastoDesdeDTO(gastoDTO);
    }
}