package br.org.fiergs.addressservice.controllers;

import br.org.fiergs.addressservice.entities.City;
import br.org.fiergs.addressservice.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping
    public List<City> list(){
        return cityService.listCity();
    }

    @GetMapping("/{name}")
    public Optional<City> listByName(@PathVariable("name")  String name){
        return cityService.findByNameCity(name);
    }

    @PostMapping
    public City save(@Valid City city){
        return cityService.saveCity(city);
    }

    @PutMapping
    public City edit(@RequestBody @Valid City city){
        return cityService.editCity(city);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        cityService.deleteCity(id);
    }
}
