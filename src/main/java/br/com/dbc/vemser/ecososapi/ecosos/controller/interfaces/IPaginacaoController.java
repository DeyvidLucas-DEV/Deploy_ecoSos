package br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces;

import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Comentario;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Ocorrencia;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface IPaginacaoController {

    @Operation(
            summary = "Listar todos os usuários paginados",
            description = "Retorna uma lista paginada de usuários."
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de usuários paginada retornada com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no servidor. Entre em contato com o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    ResponseEntity<Page<UsuarioDTO>> getAllUsers(int page, int size);

    @Operation(
            summary = "Listar todas as ocorrências paginadas",
            description = "Retorna uma lista paginada de ocorrências utilizando o PageableDefault e SortDefault.",
            externalDocs = @ExternalDocumentation(
                    description = "Link para Documentação",
                    url = "https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/web/PageableDefault.html"
            )
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de ocorrências paginada retornada com sucesso"
                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no servidor. Entre em contato com o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    ResponseEntity<Page<Ocorrencia>> ocorrenciasPaginadas(Pageable pageable);

    @Operation(
            summary = "Listar todos os comentários paginados",
            description = "Retorna uma lista paginada de comentários utilizando o PageableDefault e SortDefault",
            externalDocs = @ExternalDocumentation(
                    description = "Link para Documentação",
                    url = "https://docs.spring.io/spring-data/commons/docs/current/api/org/springframework/data/web/PageableDefault.html"
            )


    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Lista de comentários paginada retornada com sucesso"

                    ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Erro interno no servidor. Entre em contato com o administrador.",
                            content = @Content(schema = @Schema(hidden = true))
                    )
            }
    )
    ResponseEntity<Page<Comentario>> comentariosPaginados(Pageable pageable);
}
