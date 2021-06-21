package com.ceiba.usuario.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import com.ceiba.usuario.modelo.entidad.Usuario;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoUsuarioEntidad implements RowMapper<Usuario>, MapperResult {

    @Override
    public Usuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        int identificacion = resultSet.getInt("identificacion");


        return new Usuario(id,nombre,identificacion);
    }

}
