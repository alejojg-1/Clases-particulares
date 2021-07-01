package com.ceiba.curso.controlador;

import com.ceiba.curso.consulta.ManejadorBuscarCurso;
import com.ceiba.curso.consulta.ManejadorListarCurso;
import com.ceiba.curso.modelo.dto.DtoCurso;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@Api(tags={"Controlador consulta cusos"})
@CrossOrigin(origins = "http://localhost:4400")
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
    @ApiOperation("Buscar curso por id")
    public DtoCurso bucarPorId(@PathVariable Long id) {
        return this.manejadorBuscarCurso.ejecutar(id);
    }
}
