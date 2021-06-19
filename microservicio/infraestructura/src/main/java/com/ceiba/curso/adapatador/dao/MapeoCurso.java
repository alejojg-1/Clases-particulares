package com.ceiba.curso.adapatador.dao;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCurso implements RowMapper<DtoCurso>, MapperResult {

    @Override
    public DtoCurso mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String tipo = resultSet.getString("tipo");
        Double precio = resultSet.getDouble("precio");
        String descripcion = resultSet.getString("descripcion");


        return new DtoCurso(id,nombre,tipo,precio,descripcion);
    }
}
