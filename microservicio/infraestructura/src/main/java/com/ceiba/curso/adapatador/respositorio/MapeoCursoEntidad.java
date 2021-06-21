package com.ceiba.curso.adapatador.respositorio;


import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.infraestructura.jdbc.MapperResult;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoCursoEntidad implements RowMapper<Curso>, MapperResult {

    @Override
    public Curso mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String tipo = resultSet.getString("tipo");
        Double precio = resultSet.getDouble("precio");
        String descripcion = resultSet.getString("descripcion");


        return new Curso(id,nombre,tipo,descripcion,precio);
    }
}
