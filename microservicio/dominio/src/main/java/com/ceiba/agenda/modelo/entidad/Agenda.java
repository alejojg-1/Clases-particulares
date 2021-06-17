package com.ceiba.agenda.modelo.entidad;

import com.ceiba.agenda.excepcion.ExcepcionFechaFinMayor;
import com.ceiba.curso.modelo.entidad.Curso;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
public class Agenda {

    private Long id;
    private String identificacionUsuario;
    private Curso curso;
    private LocalDateTime FechaIncio;
    private LocalDateTime FechaFin;
    private BigDecimal CostoTotal;


    public Agenda(Long id,
                  String identificacionUsuario,
                  Curso curso,
                  LocalDateTime fechaIncio,
                  LocalDateTime fechaFin,
                  BigDecimal costoTotal) {
        this.id = id;
        this.identificacionUsuario = identificacionUsuario;
        this.curso = curso;
        FechaIncio = fechaIncio;
        FechaFin = fechaFin;
        CostoTotal = costoTotal;
    }

    private BigDecimal calcularValorTotal(LocalDateTime fechaIncio, LocalDateTime fechaFin, Curso curso){
        BigDecimal valorTotal = new BigDecimal(0);
        int numeroHoras = (int)calcularPeriodoEnHoras(fechaIncio,fechaFin);
        return null;
    }

    private long calcularPeriodoEnHoras(LocalDateTime fechaIncio, LocalDateTime fechaFin){
        long numeroHoras = ChronoUnit.HOURS.between(fechaIncio,fechaFin);
        return numeroHoras;
    }

    private void ValidarFechaFinMayor(LocalDateTime fechaIncio, LocalDateTime fechaFin, String mensaje){
        if(fechaFin.isBefore(fechaIncio)){
            throw new ExcepcionFechaFinMayor(mensaje);
        }
    }
}
