package br.com.dbc.vemser.ecososapi.ecosos.repository;

import br.com.dbc.vemser.ecososapi.ecosos.entity.Log;
import br.com.dbc.vemser.ecososapi.ecosos.entity.Notificacao;
import br.com.dbc.vemser.ecososapi.ecosos.entity.NotificacaoContador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


public interface NotificacaoRepository extends MongoRepository<Notificacao, String> {

    @Aggregation(pipeline = {
            "{$unwind: '$tiporisco'}",
            "{'$group': { '_id': '$tiporisco', 'quantidade': { '$sum': 1 } } }"
    })
    List<NotificacaoContador> listarPorGravidadeEContagem();

    Page<Notificacao> findAll(Pageable pageable);
}
