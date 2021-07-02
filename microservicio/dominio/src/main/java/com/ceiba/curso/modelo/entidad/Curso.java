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


    private static final String TIPO_CURSO_PRIMARIA="PRIMARIA";
    private static final String TIPO_CURSO_SECUNDARIA="SECUNDARIA";
    private static final String TIPO_CURSO_UNIVERSIDAD="UNIVERSIDAD";
    private static final String TIPO_CURSO_OTRO="OTRO";

    private static final double PRECIO_CURSO_PRIMARIA=10000;
    private static final double PRECIO_CURSO_SECUNDARIA=15000;
    private static final double PRECIO_CURSO_UNIVERSIDAD=20000;
    private static final double PRECIO_CURSO_OTRO=15000;

    private static final String SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO = "Se debe ingresar un tipo de curso válido";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CURSO = "Se debe ingresar el nombre del curso";
    private static final String SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO="Se debe de establecer un precio";
    private static final String SE_DEBE_INGRESAR_VALOR_POSITIVO = "Se debe asignar un precio positivo";


    public Curso(Long id, String nombre, String tipo, String descripcion) {
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DE_CURSO);
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO);
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO);
        validarTipoCurso(tipo);

        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        asignarPrecio(tipo);
        this.descripcion = descripcion;

    }


    public void asignarPrecio(String tipo){

        if(tipo.equalsIgnoreCase(TIPO_CURSO_PRIMARIA)){
            this.precio = PRECIO_CURSO_PRIMARIA;
        }else if(tipo.equalsIgnoreCase(TIPO_CURSO_SECUNDARIA)){
            this.precio = PRECIO_CURSO_SECUNDARIA;
        }else if(tipo.equalsIgnoreCase(TIPO_CURSO_UNIVERSIDAD)){
            this.precio = PRECIO_CURSO_UNIVERSIDAD;
        }else if(tipo.equalsIgnoreCase(TIPO_CURSO_OTRO)){
            this.precio = PRECIO_CURSO_OTRO;
        }
        ValidadorArgumento.validarPositivo(precio, SE_DEBE_INGRESAR_VALOR_POSITIVO);
    }

    private void validarTipoCurso(String tipo){

        if(!(tipo.equalsIgnoreCase(TIPO_CURSO_PRIMARIA)
                ||tipo.equalsIgnoreCase(TIPO_CURSO_SECUNDARIA)||
                tipo.equalsIgnoreCase(TIPO_CURSO_UNIVERSIDAD)||
                tipo.equalsIgnoreCase(TIPO_CURSO_OTRO)
        )
        ){
            throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO);
        }
    }






}