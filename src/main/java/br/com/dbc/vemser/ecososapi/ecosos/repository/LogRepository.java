package br.com.dbc.vemser.ecososapi.ecosos.repository;

import br.com.dbc.vemser.ecososapi.ecosos.dto.log.LogContadorDTO;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Log;
import br.com.dbc.vemser.ecososapi.ecosos.entity.LogContador;
import br.com.dbc.vemser.ecososapi.ecosos.entity.NotificacaoContador;
import br.com.dbc.vemser.ecososapi.ecosos.enums.TipoUserLog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogRepository extends MongoRepository<Log, String>{


    Page<Log> findAll(Pageable pageable);

    Page<Log> findAllByDescricaoContainingIgnoreCase(String descricao, Pageable pageable);
    Page<Log> findAllByDataContainingIgnoreCase(String data, Pageable pageable);

    @Aggregation(pipeline = {
            "{$unwind: '$gravidade'}",
            "{'$group': { '_id': '$gravidade', 'quantidade': { '$sum': 1 } } }"
    })
    List<LogContador> listaPorGravidade();


    @Aggregation(pipeline = {
            "{$unwind: '$tipoUserLog'}",
            "{'$group': { '_id': '$tipoUserLog', 'quantidade': { '$sum': 1 } } }"
    })
    List<LogContador> listaPorTipoUserLog();

    @Aggregation(pipeline = {
            "{$match: { 'gravidade': 'ALTO' }}",
            "{$group: { '_id': '$gravidade', 'quantidade': { '$sum': 1 } } }"
    })
    List<LogContador> listaPorGravidadeAlto();

    @Aggregation(pipeline = {
            "{$match: { 'gravidade': 'BAIXO' }}",
            "{$group: { '_id': '$gravidade', 'quantidade': { '$sum': 1 } } }"
    })
    List<LogContador> listaPorGravidadeBaixo();




}
