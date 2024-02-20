
package br.com.dbc.vemser.ecososapi.ecosos.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioCreateDTO {
    @NotNull(message = "Um id de endereço deve ser informado")
    @Schema(description = "Id do Endereço vinculado ao usuário", required = true, example = "101")
    private Integer idEndereco;

    @NotBlank(message = "Nome não pode ser nulo")
    @Schema(description = "Nome do Usuário", required = true, example = "Goku")
    private String nome;

    @NotBlank(message = "Telefone não pode ser nulo")
    @Schema(description = "Telefone do Usuário", required = true, example = "01987324843")
    @Size(min = 11, max = 11, message = "Telefone deve conter 11 dígitos")
    private String telefone;

    @NotBlank(message = "Email não pode ser nulo")
    @Schema(description = "Email do usuário", required = true, example = "son.goku@dbccompany.com.br")
    private String email;

    @ToString.Exclude
    @NotBlank(message = "Senha não pode ser nula")
    @Schema(description = "Senha do Usuário", required = true, example = "Chi-chi")
    private String senha;
}