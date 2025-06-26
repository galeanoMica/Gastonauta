package com.example.gastonauta.DTO;

import java.math.BigDecimal;
import java.util.Map;

public class ResumenDetalladoDTO {

    private int anio;
    private int mes;
    private BigDecimal totalGastos;
    private BigDecimal totalIngresos;
    private BigDecimal saldo;
    private Map<String, BigDecimal> gastosPorCategoria;
    private Map<String, BigDecimal> ingresosPorCategoria;

    public ResumenDetalladoDTO() {}


    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public BigDecimal getTotalGastos() { return totalGastos; }
    public void setTotalGastos(BigDecimal totalGastos) { this.totalGastos = totalGastos; }

    public BigDecimal getTotalIngresos() { return totalIngresos; }
    public void setTotalIngresos(BigDecimal totalIngresos) { this.totalIngresos = totalIngresos; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }

    public Map<String, BigDecimal> getGastosPorCategoria() { return gastosPorCategoria; }
    public void setGastosPorCategoria(Map<String, BigDecimal> gastosPorCategoria) { this.gastosPorCategoria = gastosPorCategoria; }

    public Map<String, BigDecimal> getIngresosPorCategoria() { return ingresosPorCategoria; }
    public void setIngresosPorCategoria(Map<String, BigDecimal> ingresosPorCategoria) { this.ingresosPorCategoria = ingresosPorCategoria; }
}