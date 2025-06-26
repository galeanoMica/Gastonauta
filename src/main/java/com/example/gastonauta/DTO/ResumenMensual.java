package com.example.gastonauta.DTO;

import java.math.BigDecimal;

public class ResumenMensual {

    private int anio;
    private int mes;
    private BigDecimal totalIngresos;
    private BigDecimal totalGastos;
    private BigDecimal saldo;

    public ResumenMensual() {}

    public ResumenMensual(int anio, int mes, BigDecimal totalIngresos, BigDecimal totalGastos) {
        this.anio = anio;
        this.mes = mes;
        this.totalIngresos = totalIngresos;
        this.totalGastos = totalGastos;
        this.saldo = totalIngresos.subtract(totalGastos);
    }


    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getMes() { return mes; }
    public void setMes(int mes) { this.mes = mes; }

    public BigDecimal getTotalIngresos() { return totalIngresos; }
    public void setTotalIngresos(BigDecimal totalIngresos) { this.totalIngresos = totalIngresos; }

    public BigDecimal getTotalGastos() { return totalGastos; }
    public void setTotalGastos(BigDecimal totalGastos) { this.totalGastos = totalGastos; }

    public BigDecimal getSaldo() { return saldo; }
    public void setSaldo(BigDecimal saldo) { this.saldo = saldo; }
}
