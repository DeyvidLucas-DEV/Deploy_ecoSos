package br.com.dbc.vemser.ecososapi.ecosos.dto.usuario;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    @Schema(description = "Id do Usuário", example = "109")
    private Integer idUsuario;

    @Schema(description = "Id do Endereço vinculado ao usuário", example = "101")
    private Integer idEndereco;

    @Schema(description = "Nome do Usuário", example = "Goku")
    private String nome;

    @Schema(description = "Telefone do Usuário", example = "01987324843")
    private String telefone;

    @Schema(description = "Email do usuário", example = "son.goku@dbccompany.com.br")
    private String email;
}
