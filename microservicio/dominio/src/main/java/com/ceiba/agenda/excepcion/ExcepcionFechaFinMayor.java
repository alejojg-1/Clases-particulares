package com.ceiba.agenda.excepcion;

public class ExcepcionFechaFinMayor extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ExcepcionFechaFinMayor (String mensaje) {
        super(mensaje);
    }
}
