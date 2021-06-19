package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;

import org.mockito.Mockito;

public class ServicioActuaizarCursoTest {


    @Test
    public void validarCursoExistenciaPreviaTest() {
        // arrange
        Curso curso = new CursoTestDataBuilder().conId(1L).build();
        RepositorioCurso repositorioCurso = Mockito.mock(RepositorioCurso.class);
        Mockito.when(repositorioCurso.existe(Mockito.anyLong())).thenReturn(true);
        ServicioActualizarCurso servicioActualizarCurso = new ServicioActualizarCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCurso.ejecutar(curso), ExcepcionDuplicidad.class,"El curso ya existe en el sistema");
    }








}
