package com.ceiba.curso.puerto.repository;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.usuario.modelo.entidad.Usuario;

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


}
