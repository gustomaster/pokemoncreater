package work.upar.pokemon.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.JpaRepository;
import work.upar.pokemon.entity.Pokemon;

public interface PokeRepository extends JpaRepository<Pokemon, Long>, JpaSpecificationExecutor<Pokemon> {
}

