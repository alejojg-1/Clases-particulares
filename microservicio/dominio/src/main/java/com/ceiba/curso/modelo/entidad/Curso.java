package com.ceiba.curso.modelo.entidad;

import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import lombok.Getter;

@Getter
public class Curso {

    private Long id;
    private String nombre;
    private String tipo;
    private double precio;
    private String descripcion;


    private static final String SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO = "Se debe ingresar un tipo de curso válido";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CURSO = "Se debe ingresar el nombre del curso";
    private static final String SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO="Se debe de establecer un precio";

    public Curso(Long id, String nombre, String tipo, String descripcion,double precio) {
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DE_CURSO);
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO);
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO);


        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;

    }






}