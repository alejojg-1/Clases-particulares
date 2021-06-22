package com.ceiba.curso.comando.manejador;

import com.ceiba.curso.servicio.ServicioEliminarCurso;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarCurso implements ManejadorComando<Long> {


    private final ServicioEliminarCurso servicioEliminarCurso;

    public ManejadorEliminarCurso(ServicioEliminarCurso servicioEliminarCurso) {
        this.servicioEliminarCurso = servicioEliminarCurso;
    }

    @Override
    public void ejecutar(Long idCurso) {
        this.servicioEliminarCurso.ejecutar(idCurso);
    }
}
