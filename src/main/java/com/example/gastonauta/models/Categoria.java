package com.example.gastonauta.models;

import jakarta.persistence.*;

@Entity
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String nombre;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TipoCategoria tipo;

    public Categoria() {}

    public Categoria(String nombre, TipoCategoria tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters y setters
    public int getId() { return id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoCategoria getTipo() { return tipo; }

    public void setTipo(TipoCategoria tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Categoria{" +
               "id=" + id +
               ", nombre='" + nombre + '\'' +
               ", tipo=" + tipo +
               '}';
    }
}