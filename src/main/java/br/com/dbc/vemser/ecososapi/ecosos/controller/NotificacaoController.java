package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao.NotificacaoContadorDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao.NotificacaoDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.usuario.UsuarioDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.NotificacaoContador;
import br.com.dbc.vemser.ecososapi.ecosos.service.NotificacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Tag(name = "Notificações")
@RequestMapping("/notificacoes")
public class NotificacaoController {

    private final NotificacaoService notificacaoService;

    @GetMapping("/listar-por-gravidade-e-quantidade")
    public List<NotificacaoContadorDTO> listarPorGravidadeEContagem() {
        return notificacaoService.listarPorGravidadeEContagem();
    }

    @GetMapping
    public ResponseEntity<Page<NotificacaoDTO>> listarTodos(@RequestParam(defaultValue = "0") int page,
                                                            @RequestParam(defaultValue = "10") int size)  {
        Pageable pageable = PageRequest.of(page, size, Sort.by("horario").descending());
        Page<NotificacaoDTO> notificacao = notificacaoService.listarTodasAsNotificacoes(pageable);
        return new ResponseEntity<>(notificacao, HttpStatus.OK);
    }
}
