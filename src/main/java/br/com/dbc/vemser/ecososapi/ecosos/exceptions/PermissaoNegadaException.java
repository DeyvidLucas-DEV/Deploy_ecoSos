package br.com.dbc.vemser.ecososapi.ecosos.exceptions;

public class PermissaoNegadaException extends RuntimeException {

    public PermissaoNegadaException(String message) {
        super(message);
    }

    public PermissaoNegadaException(String message, Throwable cause) {
        super(message, cause);
    }
}

