package com.ceiba.agenda.modelo.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAgenda {

    private Long id;
    private Long idUsuario;
    private Long idCurso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private double costoTotal;

}
