package br.org.fiergs.addressservice.services;

import br.org.fiergs.addressservice.entities.City;
import br.org.fiergs.addressservice.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> listCity(){
        return cityRepository.findAll();
    }

    public Optional<City> findByNameCity(String name){
        Optional<City> countryExists = cityRepository.findByNameContainingIgnoreCase(name);
        if(countryExists.isPresent()) {
            return cityRepository.findByNameContainingIgnoreCase(name);
        }else{
            throw new RuntimeException("Nenhuma cidade encontrado");
        }
    }

    public City saveCity(City city) {
        Optional<City> countryExists = cityRepository.findByNameContainingIgnoreCase(city.getName());
        if(countryExists.isPresent()){
            throw new RuntimeException("Cidade já está cadastrado");
        }

        return this.cityRepository.save(city);
    }

    public City editCity(City city) {
        Optional<City> optionalCountry = cityRepository.findByNameContainingIgnoreCaseAndIdIsNot(city.getName(), city.getId());

        if(optionalCountry.isEmpty()){
            cityRepository.save(city);
        }else {
            throw new RuntimeException("Cidade já está cadastrado");
        }
        return city;
    }

    public void deleteCity(Long id) {
        this.cityRepository.deleteById(id);
    }

}
