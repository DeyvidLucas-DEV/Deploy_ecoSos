package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IOcorrenciaController;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.ocorrencia.OcorrenciaUpdateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.service.OcorrenciaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Ocorrência")
@RequestMapping("/ocorrencia")
public class OcorrenciaController implements IOcorrenciaController{

  private final OcorrenciaService ocorrenciaService;

  @GetMapping("/listar-todas")
  public ResponseEntity<List<OcorrenciaDTO>> listarTodas() throws Exception {
    return ResponseEntity.ok(ocorrenciaService.listarTodas());
  }

  @GetMapping("/listar-todas-id/{idOcorrencia}")
  public ResponseEntity<OcorrenciaDTO> listarPorId(@PathVariable("id") Integer idOcorrencia) throws Exception {
    return ResponseEntity.ok(ocorrenciaService.listarPorId(idOcorrencia));
  }

  @GetMapping("/feed")
  public ResponseEntity<List<OcorrenciaDTO>> listarAtivas() throws Exception {
    return ResponseEntity.ok(ocorrenciaService.listarAtivas());
  }

  @GetMapping("/feed/{id}")
  public ResponseEntity<List<OcorrenciaDTO>> listarAtivasPorId(@PathVariable("id") Integer idOcorrencia) throws Exception {
    return ResponseEntity.ok(ocorrenciaService.listarAtivasPorId(idOcorrencia));
  }

  @PostMapping("/adicionar")
  public ResponseEntity<String> criar(@Valid @RequestBody OcorrenciaCreateDTO ocorrenciaCreateDTO) throws Exception {
    ocorrenciaService.adicionar(ocorrenciaCreateDTO);
    return ResponseEntity.ok("Ocorrência cadastrada!");
  }





}