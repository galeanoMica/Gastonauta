package com.example.gastonauta.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gastonauta.models.Gasto;
import com.example.gastonauta.models.Categoria;

@Repository
public interface GastoRepository extends JpaRepository<Gasto, Long> {
    
    // Buscar por categoría
    List<Gasto> findByCategoria(Categoria categoria);

    // Buscar por fecha exacta
    List<Gasto> findByFecha(LocalDate fecha);

    // Buscar por rango de fechas
    List<Gasto> findByFechaBetween(LocalDate desde, LocalDate hasta);

    Optional<Gasto> findById(Long id);
}