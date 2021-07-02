package com.ceiba.agenda.servicio.testdatabuilder;


import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.usuario.modelo.entidad.Usuario;


import java.time.LocalDateTime;


public class AgendaTestDataBuilder {

    private Long id;
    private Usuario usuario;
    private Curso curso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;


    public AgendaTestDataBuilder() {
        usuario = new Usuario(1L,"Estefanía",65464654);
        curso = new Curso(1L,"español",
                "universidad",
                "curso nivelatorio en lectura");
        fechaInicio= LocalDateTime.parse("2021-06-23T05:00:00");
        fechaFin= LocalDateTime.parse("2021-06-23T09:00:00");

    }

    public AgendaTestDataBuilder conUsuario(Usuario usuario) {
        this.usuario = usuario;
        return this;
    }
    public AgendaTestDataBuilder conCurso(Curso curso) {
        this.curso = curso;
        return this;
    }

    public AgendaTestDataBuilder conFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
        return this;
    }
    public AgendaTestDataBuilder conFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
        return this;
    }

    public Agenda build() {
        return new Agenda(id,usuario,curso,fechaInicio,fechaFin);
    }
}
