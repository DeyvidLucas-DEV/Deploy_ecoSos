package br.com.dbc.vemser.ecososapi.ecosos.dto.comentario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioCreateDTO {

    @NotNull(message = "Insira o id da ocorrência")
    private Integer idOcorrencia;

    @NotNull
    private Integer idUsuario;

    @NotBlank(message = "Insira um comentário")
    @Schema(description = "Conteúdo do comentário", required = true, example = "Situação complicada, população desesperada!")
    @Size(max = 250)
    private String conteudo;


}
