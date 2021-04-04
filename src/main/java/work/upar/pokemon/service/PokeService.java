package work.upar.pokemon.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import work.upar.pokemon.entity.Pokemon;
import work.upar.pokemon.entity.Type;
import work.upar.pokemon.repository.PokeRepository;
import work.upar.pokemon.repository.TypeRepository;

@RequiredArgsConstructor
@Service
public class PokeService {

    @Autowired
    @NonNull
    private final PokeRepository pokeRepository;

    @NonNull
    private final TypeRepository typeRepository;
    
    public List<Pokemon> findAll(){
        return pokeRepository.findAll();
    }

    public Optional<Pokemon> search(Long typeId) {
        Optional<Pokemon> Pokemontype = pokeRepository.findById(typeId);

        return Pokemontype;
    }

}
