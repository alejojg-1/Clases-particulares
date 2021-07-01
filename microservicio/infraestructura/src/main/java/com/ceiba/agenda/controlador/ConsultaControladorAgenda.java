package com.ceiba.agenda.controlador;


import com.ceiba.agenda.consulta.ManejadorBuscarAgenda;
import com.ceiba.agenda.consulta.ManejadorListarAgenda;
import com.ceiba.agenda.consulta.ManejadorListarAgendaPorIdUsuario;
import com.ceiba.agenda.modelo.dto.DtoAgenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/agendas")
@Api(tags={"Controlador consulta cusos"})
@CrossOrigin(origins = "http://localhost:4400")
public class ConsultaControladorAgenda {

    private final ManejadorListarAgenda manejadorListarAgenda;
    private final ManejadorListarAgendaPorIdUsuario manejadorListarAgendaPorIdUsuario;
    private final ManejadorBuscarAgenda manejadorBuscarAgenda;

    public ConsultaControladorAgenda(ManejadorListarAgenda manejadorListarAgenda, ManejadorListarAgendaPorIdUsuario manejadorListarAgendaPorIdUsuario, ManejadorBuscarAgenda manejadorBuscarAgenda) {
        this.manejadorListarAgenda = manejadorListarAgenda;
        this.manejadorListarAgendaPorIdUsuario = manejadorListarAgendaPorIdUsuario;
        this.manejadorBuscarAgenda =manejadorBuscarAgenda;
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

    @GetMapping("/{id}")
    @ApiOperation("Buscar agenda")
    public DtoAgenda buscarPorId(@PathVariable Long id){
        return  this.manejadorBuscarAgenda.ejecutar(id);
    }
}
