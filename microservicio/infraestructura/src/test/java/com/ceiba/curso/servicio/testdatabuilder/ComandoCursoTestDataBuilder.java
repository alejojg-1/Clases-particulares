package com.ceiba.curso.servicio.testdatabuilder;

import com.ceiba.curso.comando.ComandoCurso;


import java.util.UUID;

public class ComandoCursoTestDataBuilder {


    private Long id;
    private String nombre;
    private String tipo;
    private double precio;
    private String descripcion;


    public ComandoCursoTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        tipo = "PRIMARIA";
        precio = 10000.0;
        descripcion = "Esto es una prueba";

    }

    public ComandoCursoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public ComandoCursoTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public ComandoCursoTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }
    public ComandoCursoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ComandoCurso build() {
        return new ComandoCurso(id,nombre, tipo,precio,descripcion);
    }
}
