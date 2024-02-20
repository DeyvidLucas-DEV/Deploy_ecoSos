package br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces;

import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.*;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Usuario;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IUsuarioAdminController {

    @Operation(
            summary = "Obter relatório de comentários por pessoa",
            description = "Retorna um relatório dos comentários feitos por cada pessoa, opcionalmente filtrando por ID de usuário."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Relatório de comentários por pessoa obtido com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioComentarioRelatorioDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitação inválida. O ID de usuário fornecido não é válido.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nenhum relatório encontrado para o ID de usuário fornecido.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autorizado. É necessário autenticação para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "ID de usuário não processável. O ID fornecido não pôde ser processado.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @GetMapping("/relatorio-comentarios-por-pessoa")
    List<UsuarioComentarioRelatorioDTO> getUsuariosComentariosRelatorio(@Valid @RequestParam(required = false) Integer idUsuario);

    @Operation(
            summary = "Obter relatório de ocorrências por pessoa",
            description = "Retorna um relatório das ocorrências associadas a cada pessoa, opcionalmente filtrando por ID de usuário."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Relatório de ocorrências por pessoa obtido com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioOcorrenciaRelatorioDTO.class))
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Solicitação inválida. O ID de usuário fornecido não é válido.",
                    content = @Content(schema = @Schema(implementation = ErrorResponse.class))
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Nenhum relatório encontrado para o ID de usuário fornecido.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autorizado. É necessário autenticação para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "ID de usuário não processável. O ID fornecido não pôde ser processado.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @GetMapping("/relatorio-ocorrencias-por-pessoa")
    List<UsuarioOcorrenciaRelatorioDTO> getUsuariosOcorrenciasRelatorio(@Valid @RequestParam(required = false) Integer idUsuario);

    @Operation(
            summary = "Listar usuários",
            description = "Lista todos os usuários cadastrados no banco"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de usuários obtida com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @GetMapping("/listar-todos")
    ResponseEntity<List<UsuarioDTO>> listarTodos() throws Exception;


    @Operation(
            summary = "Listar usuários ativos",
            description = "Lista todos os usuários ativos no sistema"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de usuários obtida com sucesso",
                    content = @Content(schema = @Schema(implementation = UsuarioDTO.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "401",
                    description = "Não autorizado. É necessário autenticação para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            ),
            @ApiResponse(
                    responseCode = "422",
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @GetMapping("/listar-usuarios-ativos")
    ResponseEntity<List<UsuarioDTO>> listarUsuariosAtivos();


    @Operation(
            summary = "Atualizar usuário",
            description = "Atualiza um usuário existente"
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
                    description = "Acesso proibido. O usuário não tem permissão para acessar este recurso."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Usuário não encontrado para o ID fornecido.",
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
            description = "Remove um usuário existente"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "204",
                    description = "Usuário removido com sucesso"
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
                    responseCode = "500",
                    description = "Erro interno no servidor. Entre em contato com o administrador.",
                    content = @Content(schema = @Schema(hidden = true))
            )
    })
    @DeleteMapping("/{idUsuario}")
    ResponseEntity<Void> deletar(@PathVariable("idUsuario") Integer id) throws Exception;

    @Operation(
            summary = "Atualizar ocorrência",
            description = "Atualiza uma ocorrência no banco pelo ID. Apenas para admins"
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
                            responseCode = "401",
                            description = "Não autorizado. É necessário autenticação.",
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
    @PutMapping("/ocorrencia/atualizar/{idOcorrencia}")
    public ResponseEntity<OcorrenciaDTO> editarParaAdmin(@PathVariable("idOcorrencia") Integer idOcorrencia,
                                                         @Valid @RequestBody OcorrenciaUpdateDTO ocorrenciaAtualizar) throws Exception;

    @Operation(
            summary = "Deletar ocorrência",
            description = "Deleta qualquer ocorrência no banco pelo ID. Apenas para usuários admins"
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
    public ResponseEntity<Void> remover(@PathVariable("idOcorrencia") Integer idOcorrencia) throws Exception;
    @Operation(
            summary = "Remover comentário",
            description = "Remove um comentário de uma ocorrência. Apenas para usuário admin"
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
    public ResponseEntity<Void> removerParaAdmin(@PathVariable("idComentario") Integer id) throws Exception;

    @Operation(
            summary = "Editar comentário",
            description = "Editar um comentário de uma ocorrência. Apenas para usuário admin"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Comentário editado com sucesso."
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
    @PutMapping("/comentario/editar/{idComentario}")
    public ResponseEntity<ComentarioDTO> editarComentarioParaAdmin(@PathVariable("idComentario") Integer idComentario,
                                                                   @Valid @RequestBody ComentarioUpdateDTO comentarioUpdateDTO) throws Exception;
}
