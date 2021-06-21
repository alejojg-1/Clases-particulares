package com.ceiba.agenda.servicio;

import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;


public class ServicioEliminarAgenda {

    private final RepositorioAgenda repositorioAgenda;

    public ServicioEliminarAgenda(RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public void ejecutar(Long id) {
        this.repositorioAgenda.eliminar(id);
    }
}
