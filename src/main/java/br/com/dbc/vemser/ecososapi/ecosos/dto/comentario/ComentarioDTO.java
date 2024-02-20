package br.com.dbc.vemser.ecososapi.ecosos.dto.comentario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComentarioDTO {
    @Schema(description = "Id do Comentário", example = "18")
    private Integer idComentario;

    @Schema(description = "Conteúdo do comentário", example = "Situação complicada, população desesperada!")
    private String conteudo;
}
