package br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces;

import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public interface IOcorrenciaController {

    @Operation(
            summary = "Listar todas ocorrências",
            description = "Lista todas as ocorrências do banco"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna a lista de ocorrências com sucesso.",
                            content = @Content(schema = @Schema(implementation = OcorrenciaDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os parâmetros fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Nenhuma ocorrência encontrada no banco de dados.",
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
    @GetMapping("/listar-todas")
    ResponseEntity<List<OcorrenciaDTO>> listarTodas() throws Exception;

    @Operation(
            summary = "Listar ocorrência por id",
            description = "Lista ocorrência pelo id obtido"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna a ocorrências com sucesso.",
                            content = @Content(schema = @Schema(implementation = OcorrenciaDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os parâmetros fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Nenhuma ocorrência encontrada no banco de dados.",
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
    @GetMapping("/listar-todas-id/{idOcorrencia}")
    ResponseEntity<OcorrenciaDTO> listarPorId(@PathVariable("id") Integer idOcorrencia) throws Exception;

    @Operation(
            summary = "Listar ocorrências ativas",
            description = "Lista todas as ocorrências ativas do banco"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna a lista de ocorrências ativas com sucesso.",
                            content = @Content(schema = @Schema(implementation = OcorrenciaDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os parâmetros fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Nenhuma ocorrência encontrada no banco de dados.",
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
    @GetMapping("/feed")
    public ResponseEntity<List<OcorrenciaDTO>> listarAtivas() throws Exception;


    @Operation(
            summary = "Listar ocorrência ativa por id",
            description = "Lista a ocorrência por id se estiver ativa do banco"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Retorna a ocorrência com sucesso.",
                            content = @Content(schema = @Schema(implementation = OcorrenciaDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os parâmetros fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Nenhuma ocorrência encontrada no banco de dados.",
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
    @GetMapping("/feed/{id}")
    public ResponseEntity<List<OcorrenciaDTO>> listarAtivasPorId( @PathVariable("id") Integer idOcorrencia) throws Exception;

    @Operation(
            summary = "Criar ocorrência",
            description = "Cria uma nova ocorrência no banco"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(responseCode = "201",
                            description = "Ocorrência criada com sucesso",
                            content = @Content(schema = @Schema(implementation = OcorrenciaDTO.class))
                    ),
                    @ApiResponse(responseCode = "400",
                            description = "Requisição inválida. Verifique os parâmetros fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
                    ),
                    @ApiResponse(responseCode = "404",
                            description = "Nenhuma ocorrência encontrada com o ID fornecido.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(responseCode = "500",
                            description = "Erro interno no servidor. Contate o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(responseCode = "403",
                            description = "Acesso proibido. O usuário não tem permissão para acessar este recurso.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(responseCode = "422",
                            description = "Entidade não processável. Verifique os dados enviados.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    @PostMapping("/adicionar")
    public ResponseEntity<String> criar(@Valid @RequestBody OcorrenciaCreateDTO ocorrenciaCreateDTO) throws Exception;







}
