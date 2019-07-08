package br.org.fiergs.addressservice.repositories;

import br.org.fiergs.addressservice.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findByNameContainingIgnoreCase(String name);

    Optional<City> findByNameContainingIgnoreCaseAndIdIsNot(String name, Long id);
}
