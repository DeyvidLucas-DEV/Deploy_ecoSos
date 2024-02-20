package br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoOcorrencia;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaRelatorioDTO {
    private String nomeOcorrencia;
    private TipoOcorrencia tipoOcorrencia;
    private TipoRisco tipoRisco;
}
