package com.ceiba.agenda.adaptador.repsitorio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RespositorioAgenda;
import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;

import java.util.List;

public class RepositorioAgendaMysql implements RespositorioAgenda {


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

    public RepositorioAgendaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public Long crear(Agenda agenda) {
        return null;
    }

    @Override
    public void actualizar(Agenda agenda) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public boolean existe(Long id) {
        return false;
    }

    @Override
    public Agenda buscarPorId(Long id) {
        return null;
    }

    @Override
    public List<Agenda> buscarPorIdUsuario(Long id) {
        return null;
    }
}
