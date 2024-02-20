package br.com.dbc.vemser.ecososapi.ecosos.dto.log;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoUserLog;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LogContadorDTO {
    private String gravidade;
    private Integer quantidade;
}
