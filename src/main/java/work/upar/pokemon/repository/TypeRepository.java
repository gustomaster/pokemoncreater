package work.upar.pokemon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import work.upar.pokemon.entity.Type;

/**
 * ポケモンの第一タイプ用Repository.
 */
public interface TypeRepository extends JpaRepository<Type, Long>{
    
}
