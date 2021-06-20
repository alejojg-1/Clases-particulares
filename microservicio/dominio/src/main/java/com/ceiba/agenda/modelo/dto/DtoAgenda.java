package com.ceiba.agenda.modelo.dto;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoAgenda {

    private Long id;
    private Long idUsuario;
    private Long idCurso;
    private LocalDateTime fechaIncio;
    private LocalDateTime fechaFin;
    private double CostoTotal;

}
