package br.org.fiergs.addressservice.controllers;

import br.org.fiergs.addressservice.entities.Country;
import br.org.fiergs.addressservice.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> list(){
        return countryService.listCountry();
    }

    @GetMapping("/{name}")
    public Optional<Country> listByName(@PathVariable("name")  String name){
        return countryService.findByNameCountry(name);
    }

    @PostMapping
    public Country save(@Valid Country country){
        return countryService.saveCountry(country);
    }

    @PutMapping
    public Country edit(@RequestBody @Valid Country country){
        return countryService.editCountry(country);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        countryService.deleteCountry(id);
    }
}
