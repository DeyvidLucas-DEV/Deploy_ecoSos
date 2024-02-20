package br.com.dbc.vemser.ecososapi.ecosos.dto.comentario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ComentarioUpdateDTO {


    @NotBlank(message = "Insira um comentário")
    @Schema(description = "Conteúdo do comentário", required = true, example = "Situação complicada, população desesperada!")
    @Size(max = 250)
    private String conteudo;

}
