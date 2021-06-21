package com.ceiba.curso.controlador;

import com.ceiba.curso.consulta.ManejadorBuscarCurso;
import com.ceiba.curso.consulta.ManejadorListarCurso;
import com.ceiba.curso.modelo.dto.DtoCurso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@Api(tags={"Controlador consulta cusos"})
public class ConsultaControladorCurso {

    private final ManejadorListarCurso manejadorListarCurso;
    private final ManejadorBuscarCurso manejadorBuscarCurso;

    public ConsultaControladorCurso(ManejadorListarCurso manejadorListarCurso, ManejadorBuscarCurso manejadorBuscarCurso) {
        this.manejadorListarCurso = manejadorListarCurso;
        this.manejadorBuscarCurso = manejadorBuscarCurso;
    }

    @GetMapping
    @ApiOperation("Listar cursos")
    public List<DtoCurso> listar() {
        return this.manejadorListarCurso.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Listar curso por id")
    public List<DtoCurso> listar(@PathVariable Long id) {
        return this.manejadorBuscarCurso.ejecutar(id);
    }
}
