package com.ceiba.agenda.consulta;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.puerto.dao.DaoAgenda;

import java.util.List;

public class ManejadorListarAgenda {

    private final DaoAgenda daoAgenda;

    public ManejadorListarAgenda(DaoAgenda daoAgenda){
        this.daoAgenda = daoAgenda;
    }

    public List<DtoAgenda> ejecutar(){ return this.daoAgenda.listar(); }
}
