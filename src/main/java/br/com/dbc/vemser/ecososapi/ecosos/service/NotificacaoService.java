package br.com.dbc.vemser.ecososapi.ecosos.service;

import br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao.NotificacaoContadorDTO;
import br.com.dbc.vemser.ecososapi.ecosos.dto.notificacao.NotificacaoDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Notificacao;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoRisco;
import br.com.dbc.vemser.ecososapi.ecosos.repository.NotificacaoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;
    private final ObjectMapper objectMapper;

    public void sendMessage(String nomeOcorrencia, TipoRisco tipoRisco){
        Notificacao not = new Notificacao();

        not.setMensagem("Alerta de Ocorrências! " + nomeOcorrencia);
        not.setTiporisco(tipoRisco);
        not.setHorario(LocalDateTime.now());
        notificacaoRepository.save(not);
    }

    public List<NotificacaoContadorDTO> listarPorGravidadeEContagem() {
        return notificacaoRepository.listarPorGravidadeEContagem().stream().map(not -> {
            return new NotificacaoContadorDTO(not.getTiporisco(), not.getQuantidade());
        }).collect(Collectors.toList());
    }

    public Page<NotificacaoDTO> listarTodasAsNotificacoes(Pageable pageable) {
        return notificacaoRepository.findAll(pageable).map(not -> objectMapper.convertValue(not, NotificacaoDTO.class));
    }
}
