package com.example.gastonauta.DTO;


import java.time.LocalDate;

public class IngresoDTO {

    private double monto;
    private String descripcion;
    private LocalDate fecha;
    private Long categoriaId;
    private Long usuarioId; 

    public IngresoDTO() {}

    // Getters y setters

    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public Long getCategoriaId() { return categoriaId; }
    public void setCategoriaId(Long categoriaId) { this.categoriaId = categoriaId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}