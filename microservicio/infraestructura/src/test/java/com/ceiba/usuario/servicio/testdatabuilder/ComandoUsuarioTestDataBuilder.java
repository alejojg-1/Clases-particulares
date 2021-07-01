package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.comando.ComandoUsuario;

import java.util.UUID;

public class ComandoUsuarioTestDataBuilder {

    private long id;
    private String nombre;
    private int identificacion;


    public ComandoUsuarioTestDataBuilder() {
        nombre = UUID.randomUUID().toString();

    }

    public ComandoUsuarioTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoUsuario build() {
        return new ComandoUsuario(id,nombre, identificacion);
    }
}
