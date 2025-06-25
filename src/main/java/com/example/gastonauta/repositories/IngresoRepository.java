package com.example.gastonauta.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gastonauta.models.Ingreso;
import com.example.gastonauta.models.Categoria;

@Repository
public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
    
    // Buscar por categoría
    List<Ingreso> findByCategoria(Categoria categoria);

    // Buscar por fecha exacta
    List<Ingreso> findByFecha(LocalDate fecha);

    // Buscar por rango de fechas
    List<Ingreso> findByFechaBetween(LocalDate desde, LocalDate hasta);

    Optional<Ingreso> findById(Long id);

}