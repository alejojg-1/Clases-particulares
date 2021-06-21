package com.ceiba.agenda.servicio.testdatabuilder;

import com.ceiba.agenda.comando.ComandoAgenda;

import java.time.LocalDateTime;


public class ComandoAgendaTestDataBuilder {

    private Long id;
    private Long idUsuario;
    private Long idCurso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;


    public ComandoAgendaTestDataBuilder() {
        idUsuario = 1L;
        idCurso = 1L;
        fechaInicio= LocalDateTime.parse("2021-06-23T05:00:00");
        fechaFin= LocalDateTime.parse("2021-06-23T09:00:00");

    }

    public ComandoAgendaTestDataBuilder conIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
        return this;
    }
    public ComandoAgendaTestDataBuilder conIdCurso(Long idCurso) {
        this.idCurso = idCurso;
        return this;
    }

    public ComandoAgendaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }
    public ComandoAgendaTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public ComandoAgenda build() {
        return new ComandoAgenda(id,idUsuario,idCurso,fechaInicio,fechaFin);
    }
}
