package com.ceiba.agenda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ServicioActualizarAgendaTest {

    @Test
    public void validarAgendaExistenciaPreviaTest() {
        // arrange
        Agenda agenda = new AgendaTestDataBuilder().build();
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        Mockito.when(repositorioAgenda.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarAgenda servicioActualizarAgenda = new ServicioActualizarAgenda (repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAgenda.ejecutar(agenda), ExcepcionDuplicidad.class,"La clase no existe en el sistema");
    }

    @Test
    public void validarAgendaExistenciaPreviaPorFechaFueraDelRango() {
        // arrange
        Agenda agenda = new AgendaTestDataBuilder().build();
        List<DtoAgenda> agendas= new ArrayList<>();
        agendas.add(new DtoAgenda(2L,1L,1L,LocalDateTime.parse("2021-06-23T04:00:00"),LocalDateTime.parse("2021-06-23T10:00:00"),108000.0));
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        Mockito.when(repositorioAgenda.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAgenda.buscarPorIdUsuario(Mockito.anyLong())).thenReturn(agendas);
        ServicioActualizarAgenda servicioActualizarAgenda = new ServicioActualizarAgenda (repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAgenda.ejecutar(agenda), ExcepcionValorInvalido.class,"El limite infeior o superior están dentro del rango de la fecha");
    }


    @Test
    public void validarAgendaExistenciaPreviaPorFechaDentroDelRango() {
        // arrange
        Agenda agenda = new AgendaTestDataBuilder().build();
        List<DtoAgenda> agendas= new ArrayList<>();
        agendas.add(new DtoAgenda(2L,1L,1L,LocalDateTime.parse("2021-06-23T06:00:00"),LocalDateTime.parse("2021-06-23T08:00:00"),40000.0));
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        Mockito.when(repositorioAgenda.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAgenda.buscarPorIdUsuario(Mockito.anyLong())).thenReturn(agendas);
        ServicioActualizarAgenda servicioActualizarAgenda = new ServicioActualizarAgenda (repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAgenda.ejecutar(agenda), ExcepcionValorInvalido.class,"El limite infeior o superior están dentro del rango de la fecha");
    }

    @Test
    public void validarAgendaExistenciaPreviaPorFechaParcialDentroDelRango() {
        // arrange
        Agenda agenda = new AgendaTestDataBuilder().build();
        List<DtoAgenda> agendas= new ArrayList<>();
        agendas.add(new DtoAgenda(2L,1L,1L,LocalDateTime.parse("2021-06-23T06:00:00"),LocalDateTime.parse("2021-06-23T11:00:00"),90000.0));
        RepositorioAgenda repositorioAgenda = Mockito.mock(RepositorioAgenda.class);
        Mockito.when(repositorioAgenda.existe(Mockito.anyLong())).thenReturn(true);
        Mockito.when(repositorioAgenda.buscarPorIdUsuario(Mockito.anyLong())).thenReturn(agendas);
        ServicioActualizarAgenda servicioActualizarAgenda = new ServicioActualizarAgenda (repositorioAgenda);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarAgenda.ejecutar(agenda), ExcepcionValorInvalido.class,"El limite infeior o superior están dentro del rango de la fecha");
    }


}
