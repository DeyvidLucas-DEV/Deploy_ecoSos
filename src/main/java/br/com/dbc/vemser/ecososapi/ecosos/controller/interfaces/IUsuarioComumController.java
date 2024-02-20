package br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces;

import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IUsuarioComumController {

    @Operation(
            summary = "Exibe perfil do usuário logado",
            description = "Traz informações sobre o usuário logado"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário obtido com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requisição inválida. Verifique os parâmetros da requisição.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Recurso não encontrado.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "503",
                    description = "Serviço temporariamente indisponível. Tente novamente mais tarde.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @GetMapping("/exibir-perfil")
    ResponseEntity<UsuarioDTO> exibirPerfil() throws Exception;

    @Operation(
            summary = "Atualizar usuário",
            description = "Atualiza um usuário comum existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Usuário atualizado com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Requisição inválida. Verifique os dados do usuário fornecidos.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado para o ID fornecido.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Unprocessable Entity. Os dados fornecidos não puderam ser processados.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @PutMapping("/{idUsuario}")
    ResponseEntity<UsuarioDTO> atualizar(@PathVariable("idUsuario") Integer id,
                                         @Valid @RequestBody UsuarioUpdateDTO usuarioAtualizar) throws Exception;

    @Operation(
            summary = "Deletar usuário",
            description = "Remove um usuário comum existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Usuário comum removido com sucesso"
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "ID de usuário inválido. Verifique os parâmetros da requisição.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado para o ID fornecido.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "ID de usuário não processável. O ID fornecido não pôde ser processado.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @DeleteMapping("/{idUsuario}")
    ResponseEntity<Void> deletar(@PathVariable("idUsuario") Integer id) throws Exception;

    @Operation(
            summary = "Atualizar ocorrência feita pelo usuário logado",
            description = "Atualiza uma ocorrência feita pelo usuário logado pelo ID"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ocorrência atualizada com sucesso",
                            content = @Content(schema = @Schema(implementation = OcorrenciaDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os parâmetros fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Nenhuma ocorrência encontrada com o ID fornecido.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no servidor. Contate o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Entidade não processável. Verifique os dados enviados.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    @PutMapping("/ocorrencia/editar/{idOcorrencia}")
    public ResponseEntity<OcorrenciaDTO> editarOcorrenciaParaComum(@PathVariable("idOcorrencia") Integer idOcorrencia,
                                                                   @Valid @RequestBody OcorrenciaUpdateDTO ocorrenciaAtualizar) throws Exception;

    @Operation(
            summary = "Deletar ocorrência",
            description = "Deleta a ocorrência criada pelo usuário logado"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Ocorrência deletada com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    @DeleteMapping("/ocorrencia/remover/{idOcorrencia}")
    ResponseEntity<Void> removerOcorrenciaParaComum(@PathVariable("idOcorrencia") Integer idOcorrencia) throws Exception;

    @Operation(
            summary = "Remover comentário",
            description = "Remove um comentário de uma ocorrência feito pelo usuário logado."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Comentário removido com sucesso."
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "ID de comentário inválido. Verifique os parâmetros da requisição.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Comentário não encontrado para a ocorrência fornecida.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "ID de comentário não processável. O ID fornecido não pôde ser processado.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no servidor. Entre em contato com o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
            }
    )
    @DeleteMapping("/comentario/remover/{idComentario}")
    ResponseEntity<Void> removerComentarioParaComum(@PathVariable("idComentario") Integer id) throws Exception;

    @Operation(
            summary = "Editar comentário",
            description = "Edita um comentário de uma ocorrência feito pelo usuário logado"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Comentário editado com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os dados do comentário fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "403",
                            description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Comentário não encontrado para a ocorrência fornecida.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Comentário não processável. Os dados do comentário não puderam ser processados.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no servidor. Entre em contato com o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    @PutMapping("/comentario/editar/{idComentario}")
    public ResponseEntity<ComentarioDTO> editarComentarioParaComum(@PathVariable("idComentario") Integer idComentario,
                                                                   @Valid @RequestBody ComentarioUpdateDTO comentarioUpdateDTO) throws Exception;
}
