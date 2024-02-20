package br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
public class NotificacaoDTO {

    private String mensagem;

    private TipoRisco tiporisco;

    private LocalDateTime horario;
}
