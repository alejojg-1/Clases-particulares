package com.ceiba.agenda.servicio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioActualizarAgenda {

    private static final String EL_AGENDA_YA_EXISTE_EN_EL_SISTEMA = "La clase ya existe en el sistema";

    private final RepositorioAgenda repositorioAgenda;

    public ServicioActualizarAgenda
            ( RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public void ejecutar(Agenda agenda) {
        validarExistenciaPrevia(agenda);
        this.repositorioAgenda.actualizar(agenda);
    }

    private void validarExistenciaPrevia(Agenda agenda) {
        boolean existe = this.repositorioAgenda.existe(agenda.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_AGENDA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
