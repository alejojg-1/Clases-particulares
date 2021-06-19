package com.ceiba.agenda.servicio;

import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RespositorioAgenda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;

public class ServicioCrearAgenda {

    private static final String LA_AGENDA_YA_EXISTE_EN_EL_SISTEMA = "La agenda ya existe en el sistema";

    private final RespositorioAgenda respositorioAgenda;

    public ServicioCrearAgenda(RespositorioAgenda respositorioAgenda) {
        this.respositorioAgenda = respositorioAgenda;
    }

    public Long ejecutar(Agenda agenda) {
        validarExistenciaPrevia(agenda);
        return this.respositorioAgenda.crear(agenda);
    }

    private void validarExistenciaPrevia(Agenda agenda) {
        boolean existe = this.respositorioAgenda.existe(agenda.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(LA_AGENDA_YA_EXISTE_EN_EL_SISTEMA);
        }
    }
}
