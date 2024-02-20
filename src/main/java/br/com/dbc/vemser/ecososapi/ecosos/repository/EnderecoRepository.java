package br.com.dbc.vemser.ecososapi.ecosos.repository;

import br.com.dbc.vemser.ecososapi.ecosos.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {

    Endereco findAllByCepEquals(String cep);

}