package br.com.dbc.vemser.ecososapi.ecosos.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioUpdateDTO {

    @Schema(description = "Id do Endereço vinculado ao usuário", example = "101")
    private Integer idEndereco;

    @Schema(description = "Nome do Usuário", example = "Barbie")
    private String nome;

    @Schema(description = "Telefone do Usuário", example = "78986461209")
    @Size(min = 11, max = 11, message = "Telefone deve conter 11 dígitos")
    private String telefone;

    @Schema(description = "Email do usuário", example = "barbie@dbccompany.com.br")
    private String email;

}
