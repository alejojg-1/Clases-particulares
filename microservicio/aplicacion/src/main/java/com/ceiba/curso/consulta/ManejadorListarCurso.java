package com.ceiba.curso.consulta;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.curso.puerto.dao.DaoCurso;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarCurso {

    private final DaoCurso daoCurso;

    public ManejadorListarCurso(DaoCurso daoCurso){
        this.daoCurso = daoCurso;
    }

    public List<DtoCurso> ejecutar(){ return this.daoCurso.listar(); }
}
