package com.ceiba.usuario.servicio.testdatabuilder;

import com.ceiba.usuario.modelo.entidad.Usuario;


public class UsuarioTestDataBuilder {

    private Long id;
    private String nombreUsuario;
    private int identificacion;

    public UsuarioTestDataBuilder() {
        id = 1L;
        nombreUsuario = "1234";
        identificacion = 103841545;
    }

    public UsuarioTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public Usuario build() {
        return new Usuario(id,nombreUsuario,identificacion);
    }
}
