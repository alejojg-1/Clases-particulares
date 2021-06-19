package com.ceiba.curso.servicio;

import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.curso.puerto.repository.RepositorioCurso;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Usuario;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;

public class ServicioCrearCurso {

    private static final String TIPO_CURSO_PRIMARIA="PRIMARIA";
    private static final String TIPO_CURSO_SECUNDARIA="SECUNDARIA";
    private static final String TIPO_CURSO_UNIVERSIDAD="UNIVERSIDAD";
    private static final String TIPO_CURSO_OTRO="OTRO";

    private static final double PRECIO_CURSO_PRIMARIA=10000;
    private static final double PRECIO_CURSO_SECUNDARIA=15000;
    private static final double PRECIO_CURSO_UNIVERSIDAD=20000;
    private static final double PRECIO_CURSO_OTRO=15000;


    private static final String EL_CURSO_YA_EXISTE_EN_EL_SISTEMA = "El curso ya existe en el sistema";
    private static final String SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO = "Se debe ingresar un tipo de curso válido";
    private static final String SE_DEBE_INGRESAR_VALOR_POSITIVO = "Se debe asignar un precio positivo";


    private final RepositorioCurso repositorioCurso;

    public ServicioCrearCurso(RepositorioCurso repositorioCurso) {
        this.repositorioCurso = repositorioCurso;
    }

    public Long ejecutar(Curso curso) {
        validarExistenciaPrevia(curso);
        validarTipoCurso(curso.getTipo());
        curso = asignarPrecio(curso);
        return this.repositorioCurso.crear(curso);
    }

    private void validarExistenciaPrevia(Curso curso) {
        boolean existe = this.repositorioCurso.existe(curso.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_CURSO_YA_EXISTE_EN_EL_SISTEMA);
        }
    }

    public Curso asignarPrecio(Curso curso){
        double precio=0;

        if(curso.getTipo().equalsIgnoreCase(TIPO_CURSO_PRIMARIA)){
            precio = PRECIO_CURSO_PRIMARIA;
        }else if(curso.getTipo().equalsIgnoreCase(TIPO_CURSO_SECUNDARIA)){
            precio = PRECIO_CURSO_SECUNDARIA;
        }else if(curso.getTipo().equalsIgnoreCase(TIPO_CURSO_UNIVERSIDAD)){
            precio = PRECIO_CURSO_UNIVERSIDAD;
        }else if(curso.getTipo().equalsIgnoreCase(TIPO_CURSO_OTRO)){
            precio = PRECIO_CURSO_OTRO;
        }
        ValidadorArgumento.validarPositivo(precio, SE_DEBE_INGRESAR_VALOR_POSITIVO);
        return new Curso(curso.getId(), curso.getNombre(), curso.getTipo(), curso.getDescripcion(), precio);
    }

    private void validarTipoCurso(String tipo){

        if(!(tipo.equalsIgnoreCase(TIPO_CURSO_PRIMARIA)
                ||tipo.equalsIgnoreCase(TIPO_CURSO_SECUNDARIA)||
                tipo.equalsIgnoreCase(TIPO_CURSO_UNIVERSIDAD)||
                tipo.equalsIgnoreCase(TIPO_CURSO_OTRO)
        )
        ){
            throw new ExcepcionValorInvalido(SE_DEBE_INGRESAR_TIPO_DE_CURSO_VALIDO);
        }
    }


}
