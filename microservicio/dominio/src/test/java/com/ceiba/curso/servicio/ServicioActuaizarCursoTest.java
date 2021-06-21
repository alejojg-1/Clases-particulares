package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import org.junit.Test;

import org.mockito.Mockito;

public class ServicioActuaizarCursoTest {


    @Test
    public void validarCursoExistenciaPreviaTest() {
        // arrange
        Curso curso = new CursoTestDataBuilder().conId(1L).build();
        RepositorioCurso repositorioCurso = Mockito.mock(RepositorioCurso.class);
        Mockito.when(repositorioCurso.existe(Mockito.anyLong())).thenReturn(false);
        ServicioActualizarCurso servicioActualizarCurso = new ServicioActualizarCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCurso.ejecutar(curso), ExcepcionDuplicidad.class,"El curso no existe en el sistema");
    }








}
