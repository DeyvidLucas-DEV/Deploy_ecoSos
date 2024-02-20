package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.controller.interfaces.IEnderecoController;
import br.com.dbc.vemser.ecososapi.ecosos.dto.endereco.EnderecoCreateDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.endereco.EnderecoDTO;
import br.com.dbc.vemser.ecososapi.ecosos.service.EnderecoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/endereco")
@Tag(name = "Endereço")
@Validated
@Slf4j
public class EnderecoController implements IEnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoDTO> adicionar(@RequestBody EnderecoCreateDTO enderecoCreateDTO) throws Exception {
        log.info("");
        return new ResponseEntity<>(enderecoService.adicionar(enderecoCreateDTO), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EnderecoDTO>> listar() throws Exception {
        List<EnderecoDTO> enderecoDTOS = enderecoService.listar();
        return new ResponseEntity<>(enderecoDTOS, HttpStatus.OK);
    }
}
