package com.ceiba.agenda.puerto.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;


import java.util.List;

public interface DaoAgenda {
    /**
     * Permite listar Cursos
     * @return los Cursos
     */
    List<DtoAgenda> listar();



}