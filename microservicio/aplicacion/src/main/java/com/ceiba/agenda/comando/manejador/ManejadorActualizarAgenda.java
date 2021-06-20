package com.ceiba.agenda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.agenda.comando.ComandoAgenda;
import com.ceiba.agenda.comando.fabrica.FabricaAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.servicio.ServicioActualizarAgenda;
import com.ceiba.agenda.servicio.ServicioCrearAgenda;
import com.ceiba.curso.comando.ComandoCurso;
import com.ceiba.curso.servicio.ServicioActualizarCurso;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarAgenda implements ManejadorComando<ComandoAgenda> {

    private final ServicioActualizarAgenda servicioActualizarAgenda;
    private final FabricaAgenda fabricaAgenda;

    public ManejadorActualizarAgenda(ServicioActualizarAgenda servicioActualizarAgenda, FabricaAgenda fabricaAgenda) {
        this.servicioActualizarAgenda = servicioActualizarAgenda;
        this.fabricaAgenda =fabricaAgenda;
    }

    @Override
    public void ejecutar(ComandoAgenda comandoAgenda) {
        Agenda agenda = fabricaAgenda.crear(comandoAgenda);
        this.servicioActualizarAgenda.ejecutar(agenda);
    }


}
