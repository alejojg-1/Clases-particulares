package com.ceiba.curso.comando.manejador;

import com.ceiba.curso.comando.ComandoCurso;
import com.ceiba.curso.comando.fabrica.FabricaCurso;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.servicio.ServicioActualizarCurso;
import com.ceiba.manejador.ManejadorComando;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarCurso implements ManejadorComando<ComandoCurso> {

    private final FabricaCurso fabricaCurso;
    private final ServicioActualizarCurso servicioActualizarCurso;

    public ManejadorActualizarCurso(FabricaCurso fabricaCurso, ServicioActualizarCurso servicioActualizarCurso) {
        this.fabricaCurso = fabricaCurso;
        this.servicioActualizarCurso = servicioActualizarCurso;
    }

    @Override
    public void ejecutar(ComandoCurso comandoCurso) {
        Curso curso = this.fabricaCurso.crear(comandoCurso);
        this.servicioActualizarCurso.ejecutar(curso);
    }
}
