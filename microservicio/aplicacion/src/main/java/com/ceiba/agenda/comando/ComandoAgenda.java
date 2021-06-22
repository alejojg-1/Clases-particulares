package com.ceiba.agenda.comando;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAgenda {

    private Long id;
    private Long idUsuario;
    private Long idCurso;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;

}
