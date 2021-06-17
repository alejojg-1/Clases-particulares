package com.ceiba.curso.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoCurso {
    private Long id;
    private String nombre;
    private String tipo;
    private double precio;
    private String descripcion;
}
