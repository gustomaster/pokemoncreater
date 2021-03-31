package work.upar.pokemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import work.upar.pokemon.entity.Pokemon;
import work.upar.pokemon.repository.PokeRepository;

@Service
public class PokeService {

    @Autowired
    private PokeRepository pokeRepository;
    
    public List<Pokemon> findAll(){
        return pokeRepository.findAll();
    }

    public String search() {
        pokeRepository.findById();
        return search;
    }

}
