    package br.com.dbc.vemser.ecososapi.ecosos.service;

    import br.com.dbc.vemser.ecososapi.ecosos.dto.log.LogContadorDTO;
    import br.com.dbc.vemser.ecososapi.ecosos.dto.log.LogDTO;

    import br.com.dbc.vemser.ecososapi.ecosos.repository.LogRepository;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import lombok.RequiredArgsConstructor;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.data.domain.Page;
    import org.springframework.data.domain.Pageable;
    import org.springframework.stereotype.Service;

    import java.util.List;
    import java.util.stream.Collectors;
    @Service
    @RequiredArgsConstructor
    public class LogService {
        @Autowired
        private LogRepository logRepository;
        @Autowired
        private ObjectMapper objectMapper;
        public List<LogDTO> listAllLogs() {
            return logRepository.findAll().stream().map(log -> objectMapper.convertValue(log, LogDTO.class)).collect(Collectors.toList());
        }

        public Page<LogDTO> listAllLogsPageable(Pageable pageable) {
            return logRepository.findAll(pageable).map(log -> objectMapper.convertValue(log, LogDTO.class));
        }

        public Page<LogDTO> listAllLogsPageableByDescricao(String descricao, Pageable pageable) {
            return logRepository.findAllByDescricaoContainingIgnoreCase(descricao, pageable).map(log -> objectMapper.convertValue(log, LogDTO.class));
        }

        public Page<LogDTO> listAllLogsPageableByData(String data, Pageable pageable) {
            return logRepository.findAllByDataContainingIgnoreCase(data, pageable).map(log -> objectMapper.convertValue(log, LogDTO.class));
        }

        public List<LogContadorDTO> listarPorGravidade() {
            return logRepository.listaPorGravidade().stream().map(logContador -> objectMapper.convertValue(logContador, LogContadorDTO.class)).collect(Collectors.toList());
        }

        public List<LogContadorDTO> listarPorTipoUserLog() {
            return logRepository.listaPorTipoUserLog().stream().map(logContador -> objectMapper.convertValue(logContador, LogContadorDTO.class)).collect(Collectors.toList());
        }

        public List<LogContadorDTO> listarPorGravidadeAlto() {
            return logRepository.listaPorGravidadeAlto().stream().map(logContador -> objectMapper.convertValue(logContador, LogContadorDTO.class)).collect(Collectors.toList());
        }

        public List<LogContadorDTO> listarPorGravidadeBaixo() {
            return logRepository.listaPorGravidadeBaixo().stream().map(logContador -> objectMapper.convertValue(logContador, LogContadorDTO.class)).collect(Collectors.toList());
        }
    }
