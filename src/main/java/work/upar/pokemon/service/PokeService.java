package work.upar.pokemon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import work.upar.pokemon.entity.Pokemon;
import work.upar.pokemon.form.SearchForm;
import work.upar.pokemon.repository.PokeRepository;
import work.upar.pokemon.repository.TypeRepository;
import work.upar.pokemon.repository.Type2Repository;

/**
 * service.
 */
@RequiredArgsConstructor
@Service
public class PokeService {

    @Autowired
    @NonNull
    private final PokeRepository pokeRepository;

    @Autowired
    @NonNull
    private final PokeSpecifications pokeSpecifications;

    @NonNull
    private final TypeRepository typeRepository;


    private final Type2Repository type2Repository;
    
    public List<Pokemon> findAll(){
        return pokeRepository.findAll();
    }

    /**
     * 条件に一致するポケモンを検索する.
     *
     * @param form 検索フォーム.
     * @return 検索結果一覧.
     */
    public List<Pokemon> search(SearchForm form) {
        String name = form.getName();
        Long type = form.getType();
        String bs = form.getBaseStatus();
        Long bsv = form.getBaseStatusValue();
        Long bsj = form.getBaseStatusJudge();
        return pokeRepository.findAll(Specification
            .where(pokeSpecifications.nameContains(name))
            .and(pokeSpecifications.baseStatusContains(bs,bsv,bsj))
            .and(pokeSpecifications.typeContains(type))
        );
    }

}
