package com.ceiba.agenda.consulta;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.puerto.dao.DaoAgenda;
import org.springframework.stereotype.Component;


@Component
public class ManejadorBuscarAgenda {

    private final DaoAgenda daoAgenda;

    public ManejadorBuscarAgenda(DaoAgenda daoAgenda) {
        this.daoAgenda = daoAgenda;
    }

    public DtoAgenda ejecutar(Long id) {
        return this.daoAgenda.buscarPorId(id);
    }
}
