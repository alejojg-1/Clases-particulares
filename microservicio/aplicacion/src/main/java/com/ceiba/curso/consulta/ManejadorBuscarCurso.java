package com.ceiba.curso.consulta;

import com.ceiba.curso.modelo.dto.DtoCurso;
import com.ceiba.curso.puerto.dao.DaoCurso;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public class ManejadorBuscarCurso {
    private final DaoCurso daoCurso;

    public ManejadorBuscarCurso(DaoCurso daoCurso){
        this.daoCurso = daoCurso;
    }

    public List<DtoCurso> ejecutar(Long idCurso){ return this.daoCurso.buscarPorId(idCurso); }
}
