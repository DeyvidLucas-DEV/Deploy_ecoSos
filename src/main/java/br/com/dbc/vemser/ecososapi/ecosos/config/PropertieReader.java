package br.com.dbc.vemser.ecososapi.ecosos.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertieReader {
  @Value("${ambiente}")
  private String ambiente;

  @Value("${usuario}")
  private String usuario;

  @Value("${suporteEmail}")
  private String suporteEmail;

  public String getAmbiente() {
    return ambiente;
  }

  public String getUsuario() {
    return usuario;
  }

  public String getSuporteEmail() {
    return suporteEmail;
  }
}

