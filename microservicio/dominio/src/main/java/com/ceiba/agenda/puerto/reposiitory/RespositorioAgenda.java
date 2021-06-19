package com.ceiba.agenda.puerto.reposiitory;

import com.ceiba.agenda.modelo.entidad.Agenda;

import java.util.List;

public interface RespositorioAgenda {


    /**
     * Permite crear un curso
     * @param agenda
     * @return el id generado
     */
    Long crear(Agenda agenda);

    /**
     * Permite actualizar un usuario
     * @param agenda
     */
    void actualizar(Agenda agenda);

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
     * Permite buscar Curso
     * @param id
     * @return los Cursos
     */
    Agenda buscarPorId(Long id);

    /**
     * Permite buscar usuario
     * @param id
     * @return los Cursos
     */
    List<Agenda> buscarPorIdUsuario(Long id);

}
