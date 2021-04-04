package work.upar.pokemon.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import work.upar.pokemon.entity.Pokemon;

public interface PokeRepository extends JpaRepository<Pokemon, Long> {
  @Query("select pk from Pokemon pk where type_id = :typeId")
  List<Pokemon> getPokemon(Long typeId);
}
