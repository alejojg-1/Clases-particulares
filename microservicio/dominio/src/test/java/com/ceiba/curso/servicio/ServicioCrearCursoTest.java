package com.ceiba.curso.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.curso.servicio.testdatabuilder.CursoTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;

public class ServicioCrearCursoTest {

    private static final double PRECIO_CURSO_PRIMARIA=10000;
    private static final double PRECIO_CURSO_SECUNDARIA=15000;
    private static final double PRECIO_CURSO_UNIVERSIDAD=20000;
    private static final double PRECIO_CURSO_OTRO=15000;


    @Test
    public void validarCursoExistenciaPreviaTest() {
        // arrange
        Curso curso = new CursoTestDataBuilder().build();
        RepositorioCurso repositorioCurso = Mockito.mock(RepositorioCurso.class);
        Mockito.when(repositorioCurso.existe(Mockito.anyLong())).thenReturn(true);
        ServicioCrearCurso servicioCrearCurso = new ServicioCrearCurso(repositorioCurso);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearCurso.ejecutar(curso), ExcepcionDuplicidad.class,"El curso ya existe en el sistema");
    }



    @Test
    public void validarCursoConTipoValido(){
        // arrange
        CursoTestDataBuilder curso = new CursoTestDataBuilder().conTipo("PRIMARI");

        // act - assert
        BasePrueba.assertThrows(() -> curso.build(), ExcepcionValorInvalido.class,"Se debe ingresar un tipo de curso válido");
    }

    @Test
    public void validarPrecioCursoPorTipoPrimaria(){
        //arrage
        Curso curso = new CursoTestDataBuilder().conTipo("PRIMARIA").build();
        //act - assert
        Assertions.assertEquals((curso).getPrecio(),PRECIO_CURSO_PRIMARIA);

    }
    @Test
    public void validarPrecioCursoPorTipoSecundaria(){
        //arrage
        Curso curso = new CursoTestDataBuilder().conTipo("SECUNDARIA").build();
        //act - assert
        Assertions.assertEquals(curso.getPrecio(),PRECIO_CURSO_SECUNDARIA);

    }

    @Test
    public void validarPrecioCursoPorTipoUniversidad(){
        //arrage
        Curso curso = new CursoTestDataBuilder().conTipo("UNIVERSIDAD").build();
        //act - assert
         Assertions.assertEquals(curso.getPrecio(),PRECIO_CURSO_UNIVERSIDAD);

    }
    @Test
    public void validarPrecioCursoPorTipoOtro(){
        //arrage
        Curso curso = new CursoTestDataBuilder().conTipo("OTRO").build();
        //act - assert
        Assertions.assertEquals(curso.getPrecio(),PRECIO_CURSO_OTRO);

    }
}
