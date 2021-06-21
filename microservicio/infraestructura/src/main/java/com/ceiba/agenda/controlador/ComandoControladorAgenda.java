package com.ceiba.agenda.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.agenda.comando.ComandoAgenda;
import com.ceiba.agenda.comando.manejador.ManejadorActualizarAgenda;
import com.ceiba.agenda.comando.manejador.ManejadorCrearAgenda;
import com.ceiba.agenda.comando.manejador.ManejadorEliminarAgenda;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendas")
@Api(tags = { "Controlador comando agenda"})
public class ComandoControladorAgenda {

    private final ManejadorCrearAgenda manejadorCrearAgenda;
    private final ManejadorActualizarAgenda manejadorActualizarAgenda;
    private final ManejadorEliminarAgenda manejadorEliminarAgenda;

    @Autowired
    public ComandoControladorAgenda(ManejadorCrearAgenda manejadorCrearAgenda,
                                    ManejadorActualizarAgenda manejadorActualizarAgenda,
                                    ManejadorEliminarAgenda manejadorEliminarAgenda) {
        this.manejadorCrearAgenda = manejadorCrearAgenda;
        this.manejadorActualizarAgenda = manejadorActualizarAgenda;
        this.manejadorEliminarAgenda = manejadorEliminarAgenda;
    }

    @PostMapping
    @ApiOperation("Crear agenda")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoAgenda comandoAgenda){
        return manejadorCrearAgenda.ejecutar(comandoAgenda);
    }
    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Agenda")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarAgenda.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Agenda")
    public void actualizar(@RequestBody ComandoAgenda comandoAgenda, @PathVariable Long id) {
        comandoAgenda.setId(id);
        manejadorActualizarAgenda.ejecutar(comandoAgenda);
    }


}
