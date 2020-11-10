package work.upar.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.upar.pokemon.model.Pokemon;

public interface PokeRepository extends JpaRepository<Pokemon, Long> {
    
}
