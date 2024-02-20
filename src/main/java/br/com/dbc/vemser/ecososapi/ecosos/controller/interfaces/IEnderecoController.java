package br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces;

import br.com.dbc.vemser.ecososapi.ecosos.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.endereco.EnderecoDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface IEnderecoController {

    @Operation(
            summary = "Adicionar endereço",
            description = "Adiciona um novo endereço no banco"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Endereço adicionado com sucesso.",
                            content = @Content(schema = @Schema(implementation = EnderecoDTO.class))
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Requisição inválida. Verifique os dados do endereço fornecidos.",
                            content = @Content(schema = @Schema(implementation = ErrorResponse.class))
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
                            description = "Endereço não processável. Os dados do endereço não puderam ser processados.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "409",
                            description = "Conflito. O endereço já existe no sistema.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    @PostMapping
    ResponseEntity<EnderecoDTO> adicionar(@RequestBody EnderecoCreateDTO enderecoCreateDTO) throws Exception;

    @Operation(
            summary = "Listar endereços",
            description = "Lista todos os endereços do banco"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de endereços obtida com sucesso",
                            content = @Content(schema = @Schema(implementation = EnderecoDTO.class))
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
                            responseCode = "404",
                            description = "Nenhum endereço encontrado.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "422",
                            description = "Endereços não processáveis. Os endereços não puderam ser processados.",
                            content = @Content(schema = @Schema(hidden = true))
                    ),
                    @ApiResponse(
                            responseCode = "503",
                            description = "Serviço indisponível. O serviço de listagem de endereços não está disponível no momento.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    @GetMapping
    ResponseEntity<List<EnderecoDTO>> listar() throws Exception;
}
