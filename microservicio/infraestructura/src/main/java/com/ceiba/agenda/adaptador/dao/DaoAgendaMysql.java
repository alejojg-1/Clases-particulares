package com.ceiba.agenda.adaptador.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.puerto.dao.DaoAgenda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoAgendaMysql implements DaoAgenda {

    @SqlStatement(namespace="agenda", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="agenda", value="buscarPorIdusuario")
    private static String sqlBuscarPorIdUsuario;


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public DaoAgendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoAgenda> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoAgenda());

    }

    @Override
    public List<DtoAgenda> buscarPorIdUsuario(Long idUsuario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("usuario_id", idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorIdUsuario, paramSource,new MapeoAgenda());
    }
}
