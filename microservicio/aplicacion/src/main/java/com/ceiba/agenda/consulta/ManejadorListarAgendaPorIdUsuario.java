package com.ceiba.agenda.consulta;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.puerto.dao.DaoAgenda;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarAgendaPorIdUsuario {

    private final DaoAgenda daoAgenda;

    public ManejadorListarAgendaPorIdUsuario(DaoAgenda daoAgenda) {
        this.daoAgenda = daoAgenda;
    }

    public List<DtoAgenda> ejecutar(Long idUsuario) {
        return this.daoAgenda.buscarPorIdUsuario(idUsuario);
    }
}
