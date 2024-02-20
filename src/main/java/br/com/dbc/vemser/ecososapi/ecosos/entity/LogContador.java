package br.com.dbc.vemser.ecososapi.ecosos.entity;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoUserLog;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "ocorrencias")
public class LogContador {
    @Id
    private String gravidade;
    private Integer quantidade;
}
