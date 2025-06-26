package com.example.gastonauta.controllers;

import com.example.gastonauta.DTO.ResumenDetalladoDTO;
import com.example.gastonauta.DTO.ResumenMensual;
import com.example.gastonauta.services.ResumenService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/resumen")
@CrossOrigin(origins = "http://localhost:5173", allowCredentials = "true")
public class ResumenController {

    @Autowired
    private ResumenService resumenService;

    // GET /resumen?anio=2025&mes=6
    @GetMapping
    public ResumenMensual obtenerResumen(
            @RequestParam int anio,
            @RequestParam int mes) {
        return resumenService.generarResumen(anio, mes);
    }

    @GetMapping("/detallado")
    public ResumenDetalladoDTO obtenerResumenDetallado(
            @RequestParam int anio,
            @RequestParam int mes) {
        return resumenService.generarResumenDetallado(anio, mes);
    }
}