package com.ceiba.curso.puerto.dao;

import com.ceiba.curso.modelo.dto.DtoCurso;

import java.util.List;

public interface DaoCurso {
    /**
     * Permite listar usuarios
     * @return los usuarios
     */
    List<DtoCurso> listar();

    /**
     * Permite buscar usuario
     * @param id
     * @return los usuarios
     */
    DtoCurso buscarPorId(Long id);
}
