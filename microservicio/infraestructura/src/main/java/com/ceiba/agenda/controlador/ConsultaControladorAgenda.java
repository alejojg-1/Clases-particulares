package com.ceiba.agenda.controlador;


import com.ceiba.agenda.consulta.ManejadorListarAgenda;
import com.ceiba.agenda.consulta.ManejadorListarAgendaPorIdUsuario;
import com.ceiba.agenda.modelo.dto.DtoAgenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/agendas")
@Api(tags={"Controlador consulta cusos"})
public class ConsultaControladorAgenda {

    private final ManejadorListarAgenda manejadorListarAgenda;
    private final ManejadorListarAgendaPorIdUsuario manejadorListarAgendaPorIdUsuario;

    public ConsultaControladorAgenda(ManejadorListarAgenda manejadorListarAgenda, ManejadorListarAgendaPorIdUsuario manejadorListarAgendaPorIdUsuario) {
        this.manejadorListarAgenda = manejadorListarAgenda;
        this.manejadorListarAgendaPorIdUsuario = manejadorListarAgendaPorIdUsuario;
    }

    @GetMapping
    @ApiOperation("Listar agendas")
    public List<DtoAgenda> listar(){
        return  this.manejadorListarAgenda.ejecutar();
    }


    @GetMapping("/usuario/{idUsuario}")
    @ApiOperation("Listar agendas")
    public List<DtoAgenda> listar(@PathVariable Long idUsuario){
        return  this.manejadorListarAgendaPorIdUsuario.ejecutar(idUsuario);
    }
}
