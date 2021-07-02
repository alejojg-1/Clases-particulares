package com.ceiba.agenda.servicio;

import com.ceiba.agenda.modelo.dto.DtoAgenda;
import com.ceiba.agenda.modelo.entidad.Agenda;
import com.ceiba.agenda.puerto.reposiitory.RepositorioAgenda;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;

import java.util.List;

public class ServicioActualizarAgenda {

    private static final String EL_AGENDA_NO_EXISTE_EN_EL_SISTEMA = "La clase no existe en el sistema";
    private static final String EL_LIMITE_INFERIOR_O_SUPERIOR_ESTAN_EN_EL_RANGO_DE_FECHA="El limite infeior o superior están dentro del rango de la fecha";

    private final RepositorioAgenda repositorioAgenda;

    public ServicioActualizarAgenda ( RepositorioAgenda repositorioAgenda) {
        this.repositorioAgenda = repositorioAgenda;
    }

    public void ejecutar(Agenda agenda) {
        validarExistenciaPrevia(agenda);
        validarExistenciaPreviaDeAgendaPorFecha(agenda);
        this.repositorioAgenda.actualizar(agenda);
    }

    private void validarExistenciaPrevia(Agenda agenda) {
        boolean existe = this.repositorioAgenda.existe(agenda.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_AGENDA_NO_EXISTE_EN_EL_SISTEMA);
        }
    }

    private void validarExistenciaPreviaDeAgendaPorFecha(Agenda agenda) {
        List<DtoAgenda> agendas = this.repositorioAgenda.buscarPorIdUsuario(agenda.getUsuario().getId());
        agendas.forEach( dtoAgenda->{
            validarFechaDentroDelRango(agenda,dtoAgenda);
            validarFechaFueraDelRango(agenda,dtoAgenda);
            validarParcialDentroDelRango(agenda,dtoAgenda); });
    }

    private void validarFechaDentroDelRango(Agenda agenda, DtoAgenda dtoAgenda){
        if( (agenda.getFechaIncio().isAfter(dtoAgenda.getFechaInicio())&&agenda.getFechaFin().isBefore(dtoAgenda.getFechaFin()))){
            throw new ExcepcionValorInvalido(EL_LIMITE_INFERIOR_O_SUPERIOR_ESTAN_EN_EL_RANGO_DE_FECHA);
        }
    }

    private void validarFechaFueraDelRango(Agenda agenda, DtoAgenda dtoAgenda){
        if((agenda.getFechaIncio().isBefore(dtoAgenda.getFechaInicio())&&agenda.getFechaFin().isAfter(dtoAgenda.getFechaFin()))){
            throw new ExcepcionValorInvalido(EL_LIMITE_INFERIOR_O_SUPERIOR_ESTAN_EN_EL_RANGO_DE_FECHA);
        }
    }

    private void validarParcialDentroDelRango(Agenda agenda, DtoAgenda dtoAgenda){
        if(agenda.getFechaIncio().isBefore(dtoAgenda.getFechaInicio())&&(agenda.getFechaFin().isBefore(dtoAgenda.getFechaFin())&&agenda.getFechaFin().isAfter(dtoAgenda.getFechaInicio()))){
            throw new ExcepcionValorInvalido(EL_LIMITE_INFERIOR_O_SUPERIOR_ESTAN_EN_EL_RANGO_DE_FECHA);
        }
        else if((agenda.getFechaIncio().isAfter(dtoAgenda.getFechaInicio())&&agenda.getFechaIncio().isBefore(dtoAgenda.getFechaFin()))&&agenda.getFechaFin().isAfter(dtoAgenda.getFechaFin())){
            throw new ExcepcionValorInvalido(EL_LIMITE_INFERIOR_O_SUPERIOR_ESTAN_EN_EL_RANGO_DE_FECHA);
        }
    }
}
