package com.ceiba.usuario.controlador;

import java.util.List;

import com.ceiba.usuario.consulta.ManejadorBuscarUsuario;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import org.springframework.web.bind.annotation.*;

import com.ceiba.usuario.modelo.dto.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags={"Controlador consulta usuario"})
@CrossOrigin(origins = "http://localhost:4400")
public class ConsultaControladorUsuario {

    private final ManejadorListarUsuarios manejadorListarUsuarios;
    private final ManejadorBuscarUsuario manejadorBuscarUsuario;
    public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios, ManejadorBuscarUsuario manejadorBuscarUsuario) {
        this.manejadorListarUsuarios = manejadorListarUsuarios;
        this.manejadorBuscarUsuario=manejadorBuscarUsuario;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoUsuario> listar() {
        return this.manejadorListarUsuarios.ejecutar();
    }

    @GetMapping("/{id}")
    @ApiOperation("Listar Usuarios")
    public DtoUsuario buscarPorId(@PathVariable Long id) {
        return this.manejadorBuscarUsuario.ejecutar(id);
    }

}
