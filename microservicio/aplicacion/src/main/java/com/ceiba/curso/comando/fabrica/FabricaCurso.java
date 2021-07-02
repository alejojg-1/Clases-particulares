package com.ceiba.curso.comando.fabrica;

import com.ceiba.curso.comando.ComandoCurso;
import com.ceiba.curso.modelo.entidad.Curso;
import org.springframework.stereotype.Component;

@Component
public class FabricaCurso {

    public Curso crear(ComandoCurso comandoCurso) {
        return new Curso(
                comandoCurso.getId(),
                comandoCurso.getNombre(),
                comandoCurso.getTipo(),
                comandoCurso.getDescripcion());
    }

}
