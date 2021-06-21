package com.ceiba.agenda.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.agenda.servicio.testdatabuilder.AgendaTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import org.junit.Test;
import org.mockito.Mockito;

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

}
