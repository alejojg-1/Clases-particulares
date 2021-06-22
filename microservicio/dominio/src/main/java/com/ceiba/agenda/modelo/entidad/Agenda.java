package com.ceiba.agenda.modelo.entidad;

import com.ceiba.agenda.excepcion.ExcepcionFechaFinMayor;
import com.ceiba.curso.modelo.entidad.Curso;
import com.ceiba.dominio.ValidadorArgumento;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.usuario.modelo.entidad.Usuario;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Getter
public class Agenda {

    private Long id;
    private Usuario usuario;
    private Curso curso;
    private LocalDateTime fechaIncio;
    private LocalDateTime fechaFin;
    private double cantidadDeHoras;
    private double costoTotal;

    private static final String SE_DEBE_INGRESAR_FECHA_INICIO = "Se debe ingresar la fecha de inicio";
    private static final String SE_DEBE_INGRESAR_FECHA_FIN = "Se debe ingresar la fecha de Fin";
    private static final String SE_DEBE_ASIGANAR_UN_COSTO_TOTAL="Se debe de asignar un costo total";
    private static final String SE_DEBE_ASIGANAR_UNA_FECHA_FIN_MAYOR="La fecha o horario de fin debe de ser mayor que la fecha de inicio";
    private static final String SE_DEBE_INGRESAR_UNA_FECHA_DE_INCIO_MENOR="La fecha inicio no puede susperar un mes desde la fecha actual";

    private static final double PORCENTAJE_DESCUENTO=0.1;
    private static final int CANTIDAD_DE_HORAS_PARA_DESCUENTO=3;


    public Agenda(Long id,
                  Usuario usuario,
                  Curso curso,
                  LocalDateTime fechaIncio,
                  LocalDateTime fechaFin)
                   {

        ValidadorArgumento.validarObligatorio(fechaIncio,SE_DEBE_INGRESAR_FECHA_INICIO);
        ValidadorArgumento.validarObligatorio(fechaFin,SE_DEBE_INGRESAR_FECHA_FIN);
        validarFechaFinMayor(fechaIncio,fechaFin, SE_DEBE_ASIGANAR_UNA_FECHA_FIN_MAYOR);
        this.id = id;
        this.usuario = usuario;
        this.curso = curso;
        this.fechaIncio = fechaIncio;
        this.fechaFin = fechaFin;
        this.cantidadDeHoras=calcularPeriodoEnHoras(fechaIncio,fechaFin);
        this.costoTotal= calcularValorTotal(curso);
        validarFechaMes(fechaFin,SE_DEBE_INGRESAR_UNA_FECHA_DE_INCIO_MENOR);

    }

    private double calcularValorTotal(Curso curso){
       if(cantidadDeHoras>CANTIDAD_DE_HORAS_PARA_DESCUENTO){
           costoTotal= aplicarDescuento();
       }else{
           costoTotal = curso.getPrecio()*cantidadDeHoras;
           ValidadorArgumento.validarObligatorio(costoTotal,SE_DEBE_ASIGANAR_UN_COSTO_TOTAL);
       }
        return costoTotal;
    }

    private double aplicarDescuento(){
        return ((curso.getPrecio()*cantidadDeHoras)-(curso.getPrecio()*cantidadDeHoras*PORCENTAJE_DESCUENTO));
    }

    private double  calcularPeriodoEnHoras(LocalDateTime fechaIncio, LocalDateTime fechaFin){
        return ChronoUnit.HOURS.between(fechaIncio,fechaFin);
    }

    private void validarFechaFinMayor(LocalDateTime fechaIncio, LocalDateTime fechaFin, String mensaje){
        if(fechaFin.isBefore(fechaIncio)){
            throw new ExcepcionFechaFinMayor(mensaje);
        }
    }

    private void validarFechaMes(LocalDateTime fechaIncio, String mensaje){
        if(fechaIncio.isAfter(LocalDateTime.now().plusMonths(1))){
            throw new ExcepcionValorInvalido(mensaje);
        }
    }


}
