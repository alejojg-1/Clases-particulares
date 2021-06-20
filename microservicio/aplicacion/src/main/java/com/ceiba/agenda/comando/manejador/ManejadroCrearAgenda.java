package com.ceiba.agenda.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.agenda.comando.ComandoAgenda;
import com.ceiba.agenda.comando.fabrica.FabricaAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.servicio.ServicioCrearAgenda;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import org.springframework.stereotype.Component;

// posible erro en dependencias de fabrica
@Component
public class ManejadroCrearAgenda implements ManejadorComandoRespuesta<ComandoAgenda, ComandoRespuesta<Long>> {

    private final FabricaAgenda fabricaAgenda;
    private final ServicioCrearAgenda servicioCrearAgenda;

    public ManejadroCrearAgenda(FabricaAgenda fabricaAgenda, ServicioCrearAgenda servicioCrearAgenda) {
        this.fabricaAgenda = fabricaAgenda;
        this.servicioCrearAgenda = servicioCrearAgenda;
    }

    @Override
    public ComandoRespuesta<Long> ejecutar(ComandoAgenda comandoAgenda) {
        Agenda agenda = this.fabricaAgenda.crear(comandoAgenda);
        return new ComandoRespuesta<>(this.servicioCrearAgenda.ejecutar(agenda));
    }
}
