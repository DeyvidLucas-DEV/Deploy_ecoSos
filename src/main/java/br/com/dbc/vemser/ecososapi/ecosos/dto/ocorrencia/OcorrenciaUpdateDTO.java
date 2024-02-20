package br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoOcorrencia;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaUpdateDTO {


    @Schema(description = "Nome da ocorrência", example = "Enchente em Terra Nova")
    @Size(max = 250, message = "O nome da ocorrência deve ter no máximo 250 caracteres.")
    private String nome;

    @Schema(description = "Id do Endereço da ocorrência", example = "101")
    private Integer idEndereco;

    @Schema(description = "Gravidade da ocorrência", example = "ALTO")
    private TipoRisco gravidade;

    @Schema(description = "Descrição da ocorrência", example = "Altos níveis de água")
    private String descricao;

    @Schema(description = "Tipo da ocorrência", example = "ENCHENTE")
    private TipoOcorrencia tipo;
}
