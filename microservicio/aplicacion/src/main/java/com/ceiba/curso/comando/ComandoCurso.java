package com.ceiba.curso.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoCurso {

    private Long id;
    private String nombre;
    private String tipo;
    private double precio;
    private String descripcion;
}
