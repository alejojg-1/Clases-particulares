package com.ceiba.agenda.comando.fabrica;

import com.ceiba.agenda.comando.ComandoAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.curso.puerto.dao.DaoCurso;

import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.usuario.puerto.dao.DaoUsuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricaAgenda {

    //Corregir servicio y Dao
     @Autowired
     private final RepositorioUsuario repositorioUsuario;
     @Autowired
     private final RepositorioCurso repositorioCurso;

    public FabricaAgenda(RepositorioUsuario repositorioUsuario, RepositorioCurso repositorioCurso) {
        this.repositorioUsuario = repositorioUsuario;
        this.repositorioCurso = repositorioCurso;
    }

    public Agenda crear(ComandoAgenda comandoAgenda) {
        return new Agenda(
                comandoAgenda.getId(),
                this.repositorioUsuario.buscarPorId(comandoAgenda.getIdUsuario()),
                this.repositorioCurso.buscarPorId(comandoAgenda.getIdCurso()),
                comandoAgenda.getFechaIncio(),
                comandoAgenda.getFechaIncio()
        );

    }
}
