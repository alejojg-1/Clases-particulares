package com.ceiba.curso.adapatador.dao;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.curso.puerto.dao.DaoCurso;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class DaoCursoMysql implements DaoCurso {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="curso", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="curso", value="buscarPorId")
    private static String sqlBuscarPorId;


    public DaoCursoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoCurso> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar, new MapeoCurso());
    }

    @Override
    public DtoCurso buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId, paramSource,new MapeoCurso());
    }
}
