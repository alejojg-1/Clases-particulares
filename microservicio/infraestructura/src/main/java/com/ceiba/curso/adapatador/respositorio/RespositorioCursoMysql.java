package com.ceiba.curso.adapatador.respositorio;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RespositorioCursoMysql implements RepositorioCurso {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="curso", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="curso", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="curso", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="curso", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="curso", value="buscarPorId")
    private static String sqlBuscarPorId;


    public RespositorioCursoMysql (CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long crear(Curso curso) {
        return this.customNamedParameterJdbcTemplate.crear(curso, sqlCrear);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar, paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);

        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);
    }

    @Override
    public Curso buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId,paramSource, Curso.class);
    }

    @Override
    public void actualizar(Curso curso) {
        this.customNamedParameterJdbcTemplate.actualizar(curso, sqlActualizar);
    }

}
