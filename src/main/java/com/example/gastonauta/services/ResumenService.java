package com.example.gastonauta.services;

import com.example.gastonauta.DTO.ResumenDetalladoDTO;
import com.example.gastonauta.DTO.ResumenMensual;
import com.example.gastonauta.models.Gasto;
import com.example.gastonauta.models.Ingreso;
import com.example.gastonauta.repositories.GastoRepository;
import com.example.gastonauta.repositories.IngresoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ResumenService {

    @Autowired
    private GastoRepository gastoRepository;

    @Autowired
    private IngresoRepository ingresoRepository;

    public ResumenMensual generarResumen(int anio, int mes) {
        YearMonth yearMonth = YearMonth.of(anio, mes);
        LocalDate desde = yearMonth.atDay(1);
        LocalDate hasta = yearMonth.atEndOfMonth();

        List<Gasto> gastos = gastoRepository.findByFechaBetween(desde, hasta);
        List<Ingreso> ingresos = ingresoRepository.findByFechaBetween(desde, hasta);

        BigDecimal totalGastos = gastos.stream()
            .map(g -> BigDecimal.valueOf(g.getMonto()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal totalIngresos = ingresos.stream()
            .map(i -> BigDecimal.valueOf(i.getMonto()))
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new ResumenMensual(anio, mes, totalIngresos, totalGastos);
    }
    public ResumenDetalladoDTO generarResumenDetallado(int anio, int mes) {
        YearMonth yearMonth = YearMonth.of(anio, mes);
        LocalDate desde = yearMonth.atDay(1);
        LocalDate hasta = yearMonth.atEndOfMonth();

        List<Gasto> gastos = gastoRepository.findByFechaBetween(desde, hasta);
        List<Ingreso> ingresos = ingresoRepository.findByFechaBetween(desde, hasta);

        BigDecimal totalGastos = BigDecimal.ZERO;
        BigDecimal totalIngresos = BigDecimal.ZERO;

        Map<String, BigDecimal> gastosPorCategoria = new java.util.HashMap<>();
        for (Gasto g : gastos) {
            totalGastos = totalGastos.add(BigDecimal.valueOf(g.getMonto()));
            String nombre = g.getCategoria().getNombre();
            gastosPorCategoria.put(nombre,
                gastosPorCategoria.getOrDefault(nombre, BigDecimal.ZERO).add(BigDecimal.valueOf(g.getMonto())));
        }

        Map<String, BigDecimal> ingresosPorCategoria = new java.util.HashMap<>();
        for (Ingreso i : ingresos) {
            totalIngresos = totalIngresos.add(BigDecimal.valueOf(i.getMonto()));
            String nombre = i.getCategoria().getNombre();
            ingresosPorCategoria.put(nombre,
                ingresosPorCategoria.getOrDefault(nombre, BigDecimal.ZERO).add(BigDecimal.valueOf(i.getMonto())));
        }

        ResumenDetalladoDTO dto = new ResumenDetalladoDTO();
        dto.setAnio(anio);
        dto.setMes(mes);
        dto.setTotalGastos(totalGastos);
        dto.setTotalIngresos(totalIngresos);
        dto.setSaldo(totalIngresos.subtract(totalGastos));
        dto.setGastosPorCategoria(gastosPorCategoria);
        dto.setIngresosPorCategoria(ingresosPorCategoria);

        return dto;
    }
}