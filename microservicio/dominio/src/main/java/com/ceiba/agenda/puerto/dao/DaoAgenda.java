package com.ceiba.agenda.puerto.dao;

import com.ceiba.agenda.modelo.dto.DtoAgenda;


import java.util.List;

public interface DaoAgenda {
    /**
     * Permite listar Cursos
     * @return las agendas
     */
    List<DtoAgenda> listar();

    /**
     * Permite buscar usuario
     * @param id
     * @return las agendas
     */
    List<DtoAgenda> buscarPorIdUsuario(Long id);

    /**
     * Permite buscar usuario
     * @param id
     * @return agenda
     */

    DtoAgenda buscarPorId(Long id);
}
