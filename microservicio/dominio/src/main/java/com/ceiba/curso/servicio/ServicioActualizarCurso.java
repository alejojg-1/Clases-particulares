package com.ceiba.curso.servicio;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


public class ServicioActualizarCurso {


    private static final String EL_CURSO_NO_EXISTE_EN_EL_SISTEMA = "El curso no existe en el sistema";



    private final RepositorioCurso repositorioCurso;

    public ServicioActualizarCurso(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    public void ejecutar(Curso curso) {
        validarExistenciaPrevia(curso);
        this.repositorioCurso.actualizar(curso);
    }

    private void validarExistenciaPrevia(Curso curso) {
        boolean existe = this.repositorioCurso.existe(curso.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_CURSO_NO_EXISTE_EN_EL_SISTEMA);
        }
    }


}
