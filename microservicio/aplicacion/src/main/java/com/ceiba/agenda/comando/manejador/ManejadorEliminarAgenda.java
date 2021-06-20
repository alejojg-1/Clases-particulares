package com.ceiba.agenda.comando.manejador;

import com.ceiba.agenda.servicio.ServicioEliminarAgenda;
import com.ceiba.curso.servicio.ServicioEliminarCurso;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarAgenda implements ManejadorComando<Long>{

    private final ServicioEliminarAgenda servicioEliminarAgenda;

    public ManejadorEliminarAgenda(ServicioEliminarAgenda servicioEliminarAgenda) {
        this.servicioEliminarAgenda = servicioEliminarAgenda;
    }

    @Override
    public void ejecutar(Long idAgenda) {
        this.servicioEliminarAgenda.ejecutar(idAgenda);
    }
}
