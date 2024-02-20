package br.com.dbc.vemser.ecososapi.ecosos.repository;

import br.com.dbc.vemser.ecososapi.ecosos.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Integer> {
}
