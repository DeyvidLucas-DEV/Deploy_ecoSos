package br.com.dbc.vemser.ecososapi.ecosos.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EnderecoDTO {
    @Schema(description = "Id do Endereço", example = "100")
    private Integer idEndereco;

    @Schema(description = "Cep do Endereço", example = "40854891")
    private String cep;

    @Schema(description = "Estado do Endereço", example = "SC")
    private String estado;

    @Schema(description = "Cidade do Endereço", example = "Florianópolis")
    private String cidade;

    @Schema(description = "Bairro do Endereço", example = "Monte Verde")
    private String bairro;
}
