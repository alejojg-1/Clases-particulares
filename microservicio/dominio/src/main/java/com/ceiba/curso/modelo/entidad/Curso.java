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

    private static final String SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO = "Se debe ingresar la fecha de creación";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_CURSO = "Se debe ingresar el nombre del curso";
    private static final String SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO="Se debe de establecer un precio";

    public Curso(Long id, String nombre, String tipo, String descripcion,double precio) {
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE_DE_CURSO);
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO);
        ValidadorArgumento.validarObligatorio(nombre,SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO);
        validarTipoCurso(tipo);

        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precio = precio;
        this.descripcion = descripcion;

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


    private double asignarPrecio(String tipo){
        double precio=0;

        if(tipo.toUpperCase().equals(TIPO_CURSO_PRIMARIA)){
            precio = PRECIO_CURSO_PRIMARIA;
        }else if(tipo.toUpperCase().equals(TIPO_CURSO_SECUNDARIA)){
            precio = PRECIO_CURSO_PRIMARIA;
        }else if(tipo.toUpperCase().equals(TIPO_CURSO_UNIVERSIDAD)){
            precio = PRECIO_CURSO_UNIVERSIDAD;
        }else if(tipo.toUpperCase().equals(TIPO_CURSO_OTRO)){
            precio = PRECIO_CURSO_PRIMARIA;
        }
        ValidadorArgumento.validarObligatorio(precio,SE_DEBE_REGISTRAR_UN_PRECIO_DEL_CURSO);

        return precio;
    }


}