package br.com.dbc.vemser.ecososapi.ecosos.exceptions;

import java.sql.SQLException;

public class BancoDeDadosException extends SQLException {
  public BancoDeDadosException(Throwable cause) {
    super(cause);
  }
}