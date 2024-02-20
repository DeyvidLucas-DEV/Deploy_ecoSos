package br.com.dbc.vemser.ecososapi.ecosos.controller;

import br.com.dbc.vemser.ecososapi.ecosos.dto.log.LogContadorDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.log.LogDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao.NotificacaoContadorDTO;
import br.com.dbc.vemser.ecososapi.ecosos.service.LogService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/log")

public class LogController {
    private final LogService logService;
    @GetMapping()
    public List<LogDTO> list() {
        return logService.listAllLogs();
    }

    @GetMapping("/pageable")
    public Page<LogDTO> listPageable(@PageableDefault(size = 10, page = 0, sort = {"data"}) Pageable pageable) {
        return logService.listAllLogsPageable(pageable);
    }

    @GetMapping("/pageable/descricao")
    public Page<LogDTO> listPageableByDescricao(String descricao, @PageableDefault(size = 10, page = 0, sort = {"data"}) Pageable pageable) {
        return logService.listAllLogsPageableByDescricao(descricao, pageable);
    }
    @GetMapping("/pageable/data")
     public Page<LogDTO> listPageableByData(String data, @PageableDefault(size = 10, page = 0, sort = {"data"}) Pageable pageable) {
        return logService.listAllLogsPageableByData(data, pageable);
    }

    @GetMapping("/listar-por-gravidade")
    public List<LogContadorDTO> listarPorGravidadeEContagem() {
        return logService.listarPorGravidade();
    }

    @GetMapping("/listar-por-tipoUserLog")
    public List<LogContadorDTO> listarPorTipoUserLog() {
        return logService.listarPorTipoUserLog();
    }

    @GetMapping("/listar-por-gravidade-alto")
    public List<LogContadorDTO> listarPorGravidadeAlto() {
        return logService.listarPorGravidadeAlto();
    }

    @GetMapping("/listar-por-gravidade-baixo")
    public List<LogContadorDTO> listarPorGravidadeBaixo() {
        return logService.listarPorGravidadeBaixo();
    }
}
