package com.ceiba.curso.puerto.repository;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.usuario.modelo.entidad.Usuario;

import java.util.List;

public interface RepositorioCurso {


    /**
     * Permite crear un usuario
     * @param curso
     * @return el id generado
     */
    Long crear(Curso curso);

    /**
     * Permite actualizar un usuario
     * @param curso
     */
    void actualizar(Curso curso);

    /**
     * Permite eliminar un usuario
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un usuario con un nombre
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);
    /**
     * Permite buscar Curso por Id
     * @param id
     * @return Curso
     */
    Curso buscarPorId(Long id);


}
