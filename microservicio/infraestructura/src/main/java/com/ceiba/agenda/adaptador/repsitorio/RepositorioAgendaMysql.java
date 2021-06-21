package com.ceiba.agenda.adaptador.repsitorio;

import com.ceiba.agenda.adaptador.dao.MapeoAgenda;
import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioAgendaMysql implements RepositorioAgenda {


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="agenda", value="crear")
    private static String sqlCrear;

    @SqlStatement(namespace="agenda", value="actualizar")
    private static String sqlActualizar;

    @SqlStatement(namespace="agenda", value="eliminar")
    private static String sqlEliminar;

    @SqlStatement(namespace="agenda", value="existe")
    private static String sqlExiste;

    @SqlStatement(namespace="agenda", value="buscarPorId")
    private static String sqlBuscarPorId;

    @SqlStatement(namespace="agenda", value="buscarPorIdusuario")
    private static String sqlBuscarPorIdusuario;

    public RepositorioAgendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Agenda agenda) {
        DtoAgenda dtoAgenda = new DtoAgenda(agenda.getId(),
                agenda.getUsuario().getId(),
                agenda.getCurso().getId(),agenda.getFechaIncio(),
                agenda.getFechaFin(),agenda.getCostoTotal());

        return this.customNamedParameterJdbcTemplate.crear(dtoAgenda,sqlCrear);
    }

    @Override
    public void actualizar(Agenda agenda) {
        DtoAgenda dtoAgenda = new DtoAgenda(agenda.getId(),
                agenda.getUsuario().getId(),
                agenda.getCurso().getId(),agenda.getFechaIncio(),
                agenda.getFechaFin(),agenda.getCostoTotal());

        this.customNamedParameterJdbcTemplate.actualizar(dtoAgenda,sqlActualizar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlEliminar,paramSource);
    }

    @Override
    public boolean existe(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlExiste,paramSource, Boolean.class);

    }

    @Override
    public Agenda buscarPorId(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id",id);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlBuscarPorId,paramSource, Agenda.class);
    }

    @Override
    public List<DtoAgenda> buscarPorIdUsuario(Long idUsuario) {

        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("usuario_id",idUsuario);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscarPorIdusuario,paramSource, new MapeoAgenda());
    }
}
