package com.ceiba.curso.puerto.dao;

import com.ceiba.curso.modelo.dto.DtoCurso;

import java.util.List;

public interface DaoCurso {
    /**
     * Permite listar Cursos
     * @return los usuarios
     */
    List<DtoCurso> listar();

    /**
     * Permite buscar Curso por Id
     * @param id
     * @return Curso
     */
    DtoCurso buscarPorId(Long id);
}
