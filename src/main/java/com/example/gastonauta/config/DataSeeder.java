package com.example.gastonauta.config;

import com.example.gastonauta.models.Categoria;
import com.example.gastonauta.models.TipoCategoria;
import com.example.gastonauta.repositories.CategoriaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initCategorias(CategoriaRepository categoriaRepo) {
        return args -> {
            if (categoriaRepo.count() == 0) {
                categoriaRepo.save(new Categoria("Ocio", TipoCategoria.GASTO));
                // categoriaRepo.save(new Categoria("Ganancias", TipoCategoria.INGRESO));
                // categoriaRepo.save(new Categoria("Supermercado", TipoCategoria.GASTO));
                // categoriaRepo.save(new Categoria("Servicios", TipoCategoria.GASTO));
                // categoriaRepo.save(new Categoria("Transporte", TipoCategoria.GASTO));
            }
        };
    }
}