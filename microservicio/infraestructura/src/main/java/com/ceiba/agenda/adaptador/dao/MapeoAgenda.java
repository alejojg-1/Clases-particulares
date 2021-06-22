package com.ceiba.agenda.adaptador.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoAgenda implements RowMapper<DtoAgenda>, MapperResult {


    @Override
    public DtoAgenda mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Long idUsuario = resultSet.getLong("usuario_id");
        Long idCurso = resultSet.getLong("curso_id");
        LocalDateTime fechaInicio =  resultSet.getTimestamp("fecha_inicio").toLocalDateTime();
        LocalDateTime fechaFin = resultSet.getTimestamp("fecha_fin").toLocalDateTime();
        double costoTotal = resultSet.getDouble("costo_total");


        return new DtoAgenda(id,idUsuario,idCurso,fechaInicio,fechaFin,costoTotal);
    }

}
