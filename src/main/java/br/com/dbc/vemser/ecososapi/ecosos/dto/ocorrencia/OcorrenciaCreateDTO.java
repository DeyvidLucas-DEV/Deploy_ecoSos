package br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoOcorrencia;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaCreateDTO {
  @NotNull(message = "O nome da ocorrência não pode ser vazio nem nulo.")
  @Schema(description = "Nome da ocorrência", required = true, example = "Enchente em Terra Nova")
  @Size(max = 250, message = "O nome da ocorrência deve ter no máximo 250 caracteres.")
  private String nome;

  @Schema(description = "Id do Endereço da ocorrência", required = true, example = "101")
  private Integer idEndereco;

  @Schema(description = "Id do Usuário da ocorrência", required = true, example = "109")
  private Integer idUsuario;


  @NotNull(message = "Gravidade não pode ser nula")
  @Schema(description = "Gravidade da ocorrência", required = true, example = "ALTO")
  private TipoRisco gravidade;

  @NotBlank(message = "A descrição da ocorrência não pode ser vazia nem nula.")
  @Schema(description = "Descrição da ocorrência", required = true, example = "Altos níveis de água")
  private String descricao;

  @NotNull(message = "O tipo da ocorrência não pode ser nulo.")
  @Schema(description = "Tipo da ocorrência", required = true, example = "ENCHENTE")
  private TipoOcorrencia tipo;
}
