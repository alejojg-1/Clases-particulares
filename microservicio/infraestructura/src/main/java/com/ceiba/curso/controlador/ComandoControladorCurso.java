package com.ceiba.curso.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.curso.comando.ComandoCurso;
import com.ceiba.curso.comando.manejador.ManejadorActualizarCurso;
import com.ceiba.curso.comando.manejador.ManejadorCrearCurso;
import com.ceiba.curso.comando.manejador.ManejadorEliminarCurso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
@Api(tags = { "Controlador comando curso"})
public class ComandoControladorCurso {


    private final ManejadorCrearCurso manejadorCrearCurso;
    private final ManejadorEliminarCurso manejadorEliminarCurso;
    private final ManejadorActualizarCurso manejadorActualizarCurso;

    @Autowired
    public ComandoControladorCurso(ManejadorCrearCurso manejadorCrearCurso,
                                     ManejadorEliminarCurso manejadorEliminarCurso,
                                     ManejadorActualizarCurso manejadorActualizarCurso) {
        this.manejadorCrearCurso = manejadorCrearCurso;
        this.manejadorEliminarCurso = manejadorEliminarCurso;
        this.manejadorActualizarCurso = manejadorActualizarCurso;
    }

    @PostMapping
    @ApiOperation("Crear Curso")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCurso comandoCurso) {
        return manejadorCrearCurso.ejecutar(comandoCurso);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Curso")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCurso.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Curso")
    public void actualizar(@RequestBody ComandoCurso comandoCurso,@PathVariable Long id) {
        comandoCurso.setId(id);
        manejadorActualizarCurso.ejecutar(comandoCurso);
    }
}
