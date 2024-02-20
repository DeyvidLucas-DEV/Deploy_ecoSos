package br.com.dbc.vemser.ecososapi.ecosos.dto.endereco;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class EnderecoCreateDTO {
    @NotBlank(message = "Informe um CEP")
    @Schema(description = "Cep do Endereço", required = true, example = "40854891")
    @Size(min = 8, max = 8, message = "O CEP deve conter exatamente 8 números.")
    private String cep;

    @NotBlank(message = "Informe um estado")
    @Schema(description = "Estado do Endereço", required = true, example = "SC")
    @Size(min = 2, max = 2, message = "Informe uma sigla")
    private String estado;

    @NotBlank(message = "Informe uma cidade")
    @Schema(description = "Cidade do Endereço", required = true, example = "Florianópolis")
    @Size(max = 60, message = "Limite de caracteres")
    private String cidade;

    @NotBlank(message = "Informe um bairro")
    @Schema(description = "Bairro do Endereço", required = true, example = "Monte Verde")
    @Size(max = 60, message = "Limite de caracteres")
    private String bairro;
}
