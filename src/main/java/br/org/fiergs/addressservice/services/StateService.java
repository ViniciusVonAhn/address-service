package br.org.fiergs.addressservice.services;

import br.org.fiergs.addressservice.entities.State;
import br.org.fiergs.addressservice.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    public List<State> listState(){
        return stateRepository.findAll();
    }

    public Optional<State> findByNameState(String name){
        Optional<State> countryExists = stateRepository.findByNameContainingIgnoreCase(name);
        if(countryExists.isPresent()) {
            return stateRepository.findByNameContainingIgnoreCase(name);
        }else{
            throw new RuntimeException("Nenhum estado encontrado");
        }
    }

    public State saveState(State state) {
        Optional<State> countryExists = stateRepository.findByNameContainingIgnoreCase(state.getName());
        if(countryExists.isPresent()){
            throw new RuntimeException("Estado já está cadastrado");
        }

        return this.stateRepository.save(state);
    }

    public State editState(State state) {
        Optional<State> optionalCountry = stateRepository.findByNameContainingIgnoreCaseAndIdIsNot(state.getName(), state.getId());

        if(optionalCountry.isEmpty()){
            stateRepository.save(state);
        }else {
            throw new RuntimeException("Estado já está cadastrado");
        }
        return state;
    }

    public void deleteState(Long id) {
        this.stateRepository.deleteById(id);
    }


}
