package br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificacaoContadorDTO {

    private TipoRisco tiporisco;

    private Integer quantidade;
}
