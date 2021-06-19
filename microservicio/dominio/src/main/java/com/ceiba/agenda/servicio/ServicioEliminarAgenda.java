package com.ceiba.agenda.servicio;

import com.ceiba.agenda.puerto.reposiitory.RespositorioAgenda;


public class ServicioEliminarAgenda {

    private final RespositorioAgenda repositorioAgenda;

    public ServicioEliminarAgenda(RespositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public void ejecutar(Long id) {
        this.repositorioAgenda.eliminar(id);
    }
}
