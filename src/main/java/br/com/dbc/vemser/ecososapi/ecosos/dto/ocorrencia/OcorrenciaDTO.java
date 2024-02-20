package br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia;

import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoOcorrencia;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import java.sql.Timestamp;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OcorrenciaDTO {
  @Schema(description = "Id da Ocorrência", example = "100")
  private Integer idOcorrencia;

  @Schema(description = "Nome da ocorrência", example = "Enchente em Terra Nova")
  private String nome;

  @Schema(description = "Id do Endereço da ocorrência", example = "101")
  private Integer idEndereco;

  @Schema(description = "Id do Usuário da ocorrência", example = "109")
  private Integer idUsuario;

  @Schema(description = "Gravidade da ocorrência", example = "ALTO")
  private TipoRisco gravidade;

  @Schema(description = "Descrição da ocorrência", example = "Altos níveis de água")
  private String descricao;

  @Schema(description = "Tipo da ocorrência", example = "ENCHENTE")
  private TipoOcorrencia tipo;

  @Schema(description = "Data de Criação da Ocorrência", example = "2024-01-28 12:19:40.523872")
  private Timestamp criadoEm;

}

