package com.ceiba.agenda.comando;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoAgenda {

    private Long id;
    private Long idUsuario;
    private Long idCurso;
    private LocalDateTime fechaInicio= LocalDateTime.now();
    private LocalDateTime fechaFinal= LocalDateTime.now().plusHours(3);

}
