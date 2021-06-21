package com.ceiba.agenda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.agenda.excepcion.ExcepcionFechaFinMayor;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCrearAgendaTest {

    @Test
    public void validarAgendaExistenciaPreviaTest() {
        // arrange
        Agenda agenda = new AgendaTestDataBuilder().build();
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        Mockito.when(repositorioAgenda.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAgenda servicioCrearAgenda = new ServicioCrearAgenda (repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAgenda.ejecutar(agenda), ExcepcionDuplicidad.class,"La agenda ya existe en el sistema");
    }

    @Test
    public void validarAgendaExistenciaRangoFechaTest() {
        // arrange
        Agenda agenda = new AgendaTestDataBuilder().conFechaInicio(LocalDateTime.parse("2021-06-23T05:00:00")).build();
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        Mockito.when(repositorioAgenda.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearAgenda servicioCrearAgenda = new ServicioCrearAgenda (repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearAgenda.ejecutar(agenda), ExcepcionDuplicidad.class,"El usuario ya tiene una agenda registrada en esa fecha");
    }

    @Test
    public void validarValorTotal(){
        // arrange
        double costoTotal = 40000.0;
        Agenda agenda = new AgendaTestDataBuilder().conFechaFin(LocalDateTime.parse("2021-06-23T07:00:00")).build();
        //act - assert
        Assertions.assertEquals(agenda.getCostoTotal(),costoTotal);

    }

    @Test
    public void ValidarValorTotalConDescuento(){
        // arrange
        double costoTotal = 90000.0;
        Agenda agenda = new AgendaTestDataBuilder().conFechaFin(LocalDateTime.parse("2021-06-23T10:00:00")).build();
        //act - assert
        Assertions.assertEquals(agenda.getCostoTotal(),costoTotal);
    }

    @Test
    public void ValidarFechaMesValida(){
        // arrange
        AgendaTestDataBuilder agenda = new AgendaTestDataBuilder().conFechaInicio(LocalDateTime.now().plusMonths(2)).conFechaFin(LocalDateTime.now().plusMonths(2).plusHours(5));
        //act - assert
        BasePrueba.assertThrows(() -> agenda.build(), ExcepcionValorInvalido.class,"La fecha inicio no puede susperar un mes desde la fecha actual");

    }

    @Test
    public void ValidarFechaFinMayor(){
        // arrange
         AgendaTestDataBuilder agenda = new AgendaTestDataBuilder().conFechaFin(LocalDateTime.parse("2021-06-23T04:00:00"));
        //act - assert
        BasePrueba.assertThrows(() -> agenda.build(), ExcepcionFechaFinMayor.class,"La fecha o horario de fin debe de ser mayor que la fecha de inicio");

    }



}
