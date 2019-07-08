package br.org.fiergs.addressservice.services;

import br.org.fiergs.addressservice.entities.Country;
import br.org.fiergs.addressservice.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> listCountry(){
        return countryRepository.findAll();
    }

    public Optional<Country> findByNameCountry(String name){
        Optional<Country> countryExists = countryRepository.findByNameContainingIgnoreCase(name);
        if(countryExists.isPresent() && countryExists != null) {
            return countryRepository.findByNameContainingIgnoreCase(name);
        }else{
            throw new RuntimeException("Nenhum país encontrado");
        }
    }

    public Country saveCountry(Country country) {
        Optional<Country> countryExists = countryRepository.findByNameContainingIgnoreCase(country.getName());
        if(countryExists.isPresent()){
            throw new RuntimeException("País já está cadastrado");
        }

        return this.countryRepository.save(country);
    }

    public Country editCountry(Country country) {
        Optional<Country> optionalCountry = countryRepository.findByNameContainingIgnoreCaseAndIdIsNot(country.getName(), country.getId());

        if(optionalCountry.isEmpty()){
            countryRepository.save(country);
        }else {
            throw new RuntimeException("País já está cadastrado");
        }
        return country;
    }

    public void deleteCountry(Long id) {
        this.countryRepository.deleteById(id);
    }

}
