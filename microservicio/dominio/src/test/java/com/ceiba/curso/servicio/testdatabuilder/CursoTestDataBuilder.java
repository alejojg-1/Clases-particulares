package com.ceiba.curso.servicio.testdatabuilder;

import com.ceiba.curso.modelo.entidad.Curso;

import java.util.UUID;

public class CursoTestDataBuilder {

    private Long id;
    private String nombre;
    private String tipo;
    private double precio;
    private String descripcion;


    public CursoTestDataBuilder() {
        nombre = UUID.randomUUID().toString();
        tipo = "PRIMARIA";
        precio = 10000.0;
        descripcion = "Esto es una prueba";

    }

    public CursoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public CursoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }
    public CursoTestDataBuilder conTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public CursoTestDataBuilder conPrecio(double precio) {
        this.precio = precio;
        return this;
    }
    public CursoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public Curso build() {
        return new Curso(id,nombre, tipo,descripcion);
    }
}
