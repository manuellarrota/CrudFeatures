package com.manuellarrota.crudfeatures.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase usada para mostrar errores en capa de servicios.
 *
 * @author manuel Larrota 14/08/2019
 */
public class GenericErrorDto extends Exception {

    private final Integer httpStatus;
    private final String message;

    /**
     * Constructor de la clase.
     *
     * @param httpStatus   Status
     * @param mensaje      mensaje

     */
    public GenericErrorDto(Integer httpStatus, String mensaje) {
        super(mensaje);
        Logger log = LoggerFactory.getLogger(this.getClass());
        log.error(mensaje);
        this.httpStatus = httpStatus;
        this.message = mensaje;
        //Extraigo la traza del error para poderla almacenar como string con sus detalles
        StringBuffer sb = new StringBuffer(1024);
        StackTraceElement[] st = this.getStackTrace();
        sb.append(this.getClass().getName() + ": " + this.getMessage() + "\n");
        for (int i = 0; i < st.length; i++) {
            sb.append("\t at " + st[i].toString() + "\n");
        }
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Integer getHttpStatus() {
        return httpStatus;
    }
}
