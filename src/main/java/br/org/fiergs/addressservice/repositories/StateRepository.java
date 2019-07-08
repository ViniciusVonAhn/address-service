package br.org.fiergs.addressservice.repositories;

import br.org.fiergs.addressservice.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findByNameContainingIgnoreCase(String name);

    Optional<State> findByNameContainingIgnoreCaseAndIdIsNot(String name, Long id);
}
