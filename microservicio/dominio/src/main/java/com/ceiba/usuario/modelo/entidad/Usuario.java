package com.ceiba.usuario.modelo.entidad;


import lombok.Getter;


import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class Usuario {

    private static final String SE_DEBE_INGRESAR_LA_IDENTIFICACION = "Se debe ingresar la identificación";
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO = "Se debe ingresar el nombre de usuario";


    private long id;
    private String nombre;
    private int identificacion;

    public Usuario(long id,String nombre,int identificacion) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE_DE_USUARIO);
        validarObligatorio(identificacion, SE_DEBE_INGRESAR_LA_IDENTIFICACION);

        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

}
