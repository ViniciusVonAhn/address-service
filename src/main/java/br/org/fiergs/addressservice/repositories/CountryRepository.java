package br.org.fiergs.addressservice.repositories;

import br.org.fiergs.addressservice.entities.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

    Optional<Country> findByNameContainingIgnoreCase(String name);

    Optional<Country> findByNameContainingIgnoreCaseAndIdIsNot(String name, Long id);

    Page<Country> findAll(Pageable pageable);
}
