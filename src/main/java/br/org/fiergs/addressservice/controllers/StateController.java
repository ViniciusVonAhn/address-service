package br.org.fiergs.addressservice.controllers;

import br.org.fiergs.addressservice.entities.State;
import br.org.fiergs.addressservice.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staties")
public class StateController {

    @Autowired
    private StateService stateService;

    @GetMapping
    public List<State> liststate(){
        return stateService.listState();
    }

    @GetMapping("/{name}")
    public Optional<State> listByName(@PathVariable("name") String name){
        return stateService.findByNameState(name);
    }

    @PostMapping
    public State save(@Valid State state){
        return stateService.saveState(state);
    }

    @PutMapping
    public State edit(@RequestBody @Valid State state){
        return stateService.editState(state);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        stateService.deleteState(id);
    }
}
