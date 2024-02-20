package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IUsuarioAdminController;
import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IUsuarioComumController;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.*;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Usuario;
import br.com.dbc.vemser.ecososapi.ecosos.service.ComentarioService;
import br.com.dbc.vemser.ecososapi.ecosos.service.OcorrenciaService;
import br.com.dbc.vemser.ecososapi.ecosos.service.UsuarioAdminService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Usuário Admin")
@RequestMapping("/usuarioadmin")
public class UsuarioAdminController implements IUsuarioAdminController  {

    private final UsuarioAdminService usuarioAdminService;
    private final OcorrenciaService ocorrenciaService;
    private final ComentarioService comentarioService;
    @GetMapping("/relatorio-comentarios-por-pessoa")
    public List<UsuarioComentarioRelatorioDTO> getUsuariosComentariosRelatorio(@Valid @RequestParam(required = false) Integer idUsuario) {
        return usuarioAdminService.listPessoaComentarios(idUsuario);
    }

    @GetMapping("/relatorio-ocorrencias-por-pessoa")
    public List<UsuarioOcorrenciaRelatorioDTO> getUsuariosOcorrenciasRelatorio(@Valid @RequestParam(required = false) Integer idUsuario) {
        return usuarioAdminService.listPessoaOcorrencias(idUsuario);
    }

    @GetMapping("/listar-todos")
    public ResponseEntity<List<UsuarioDTO>> listarTodos() throws Exception {
        return ResponseEntity.ok(usuarioAdminService.listar());
    }

    @GetMapping("/listar-usuarios-ativos")
    public ResponseEntity<List<UsuarioDTO>> listarUsuariosAtivos() {
        return ResponseEntity.ok(usuarioAdminService.listarUsuariosAtivos());
    }

    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable("idUsuario") Integer id,
                                                @Valid @RequestBody UsuarioUpdateDTO usuarioAtualizar) throws Exception {
        return new ResponseEntity<>(usuarioAdminService.atualizar(id, usuarioAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deletar(@PathVariable("idUsuario") Integer id) throws Exception {
        usuarioAdminService.deletar(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/comentario/editar/{idComentario}")
    public ResponseEntity<ComentarioDTO> editarComentarioParaAdmin(@PathVariable("idComentario") Integer idComentario,
                                                                 @Valid @RequestBody ComentarioUpdateDTO comentarioUpdateDTO) throws Exception{
        return new ResponseEntity<>(comentarioService.atualizarParaAdmin(idComentario, comentarioUpdateDTO), HttpStatus.OK);
    }

    @DeleteMapping("/ocorrencia/remover/{idOcorrencia}")
    public ResponseEntity<Void> remover(@PathVariable("idOcorrencia") Integer idOcorrencia) throws Exception{
        ocorrenciaService.removerDeAdmin(idOcorrencia);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/comentario/remover/{idComentario}")
    public ResponseEntity<Void> removerParaAdmin(@PathVariable("idComentario") Integer id) throws Exception {
        comentarioService.removerParaAdmin(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/ocorrencia/atualizar/{idOcorrencia}")
    public ResponseEntity<OcorrenciaDTO> editarParaAdmin(@PathVariable("idOcorrencia") Integer idOcorrencia,
                                                         @Valid @RequestBody OcorrenciaUpdateDTO ocorrenciaAtualizar) throws Exception{
        return ResponseEntity.ok(ocorrenciaService.atualizarParaAdmin(idOcorrencia, ocorrenciaAtualizar));
    }

}
