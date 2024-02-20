package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IUsuarioComumController;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.service.ComentarioService;
import br.com.dbc.vemser.ecososapi.ecosos.service.OcorrenciaService;
import br.com.dbc.vemser.ecososapi.ecosos.service.UsuarioComumService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Tag(name = "Usuario Comum")
@RequestMapping("/usuariocomum")
public class UsuarioComumController implements IUsuarioComumController {

    private final UsuarioComumService usuarioComumService;
    private final OcorrenciaService ocorrenciaService;
    private final ComentarioService comentarioService;

    @GetMapping("/exibir-perfil")
    public ResponseEntity<UsuarioDTO> exibirPerfil() throws Exception {
        UsuarioDTO usuarioDTOS = usuarioComumService.verPerfil();
        return ResponseEntity.ok(usuarioDTOS);
    }

    @PutMapping("/ocorrencia/editar/{idOcorrencia}")
    public ResponseEntity<OcorrenciaDTO> editarOcorrenciaParaComum(@PathVariable("idOcorrencia") Integer idOcorrencia,
                                                         @Valid @RequestBody OcorrenciaUpdateDTO ocorrenciaAtualizar) throws Exception{
        return ResponseEntity.ok(ocorrenciaService.atualizarParaComum(idOcorrencia, ocorrenciaAtualizar));
    }

    @DeleteMapping("/comentario/remover/{idComentario}")
    public ResponseEntity<Void> removerComentarioParaComum(@PathVariable("idComentario") Integer id) throws Exception {
        comentarioService.removerParaComum(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/ocorrencia/remover/{idOcorrencia}")
    public ResponseEntity<Void> removerOcorrenciaParaComum(@PathVariable("idOcorrencia") Integer idOcorrencia) throws Exception{
        ocorrenciaService.removerDeComum(idOcorrencia);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/comentario/editar/{idComentario}")
    public ResponseEntity<ComentarioDTO> editarComentarioParaComum(@PathVariable("idComentario") Integer idComentario,
                                                                   @Valid @RequestBody ComentarioUpdateDTO comentarioUpdateDTO) throws Exception{
        return new ResponseEntity<>(comentarioService.atualizarParaComum(idComentario, comentarioUpdateDTO), HttpStatus.OK);
    }


    @PutMapping("/{idUsuario}")
    public ResponseEntity<UsuarioDTO> atualizar(@PathVariable("idUsuario") Integer id,
                                             @Valid @RequestBody UsuarioUpdateDTO usuarioAtualizar) throws Exception {
        return new ResponseEntity<>(usuarioComumService.atualizar(id, usuarioAtualizar), HttpStatus.OK);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deletar(@PathVariable("idUsuario") Integer id) throws Exception {
        usuarioComumService.deletar(id);
        return ResponseEntity.ok().build();
    }




}
