package com.example.gastonauta.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gastonauta.models.Categoria;
import com.example.gastonauta.models.TipoCategoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
    //filtrar categorías por tipo (GASTO o INGRESO)
    List<Categoria> findByTipo(TipoCategoria tipo);
}