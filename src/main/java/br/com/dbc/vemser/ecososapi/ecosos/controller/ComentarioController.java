package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IComentarioController;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.comentario.ComentarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.service.ComentarioService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Comentário")
@RequestMapping("/comentario")
public class ComentarioController implements IComentarioController {

    private final ComentarioService comentarioService;

    @GetMapping("/{idOcorrencia}")
    public ResponseEntity<List<ComentarioDTO>> listar(@PathVariable("idOcorrencia") Integer idOcorrencia) throws Exception{
        List<ComentarioDTO> comentarioDTOS = comentarioService.listarPorComentario(idOcorrencia);
        return ResponseEntity.ok(comentarioDTOS);
    }

    @PostMapping("/ocorrencia/usuario")
    public ResponseEntity<String> adicionarComentario(@RequestBody @Valid ComentarioCreateDTO comentarioCreateDTO) throws Exception {
        comentarioService.adicionar(comentarioCreateDTO.getIdOcorrencia(), comentarioCreateDTO.getIdUsuario(), comentarioCreateDTO);
        return ResponseEntity.ok("Comentário cadastrado!");
    }



}
