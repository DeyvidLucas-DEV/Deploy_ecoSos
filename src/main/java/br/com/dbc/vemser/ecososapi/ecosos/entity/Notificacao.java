package br.com.dbc.vemser.ecososapi.ecosos.entity;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "notificacao")
public class Notificacao {

    @Id
    private String idLog;

    private String mensagem;

    @Enumerated(EnumType.STRING)
    private TipoRisco tiporisco;

    private LocalDateTime horario;

}
