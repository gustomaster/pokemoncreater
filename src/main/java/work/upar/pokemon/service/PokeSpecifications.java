package work.upar.pokemon.service;

import java.util.Objects;
import javax.persistence.criteria.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import work.upar.pokemon.entity.Pokemon;

// JPAは動的なSQL生成に向いていないためJPASpecificationを利用する
@Service
public class PokeSpecifications {

  /**
   * 受け取ったnameを元にnameを検索するSQLのwhere句を返却する
   *
   * @param name  ポケモン名.
   * @return nameがnull:         null.
   * @return nameがnullではない:  nameを検索するためのwhere句
   */
  public Specification<Pokemon> nameContains(String name) {

    return StringUtils.isEmpty(name) ? null : new Specification<Pokemon>() {
        @Override
        public Predicate toPredicate(Root<Pokemon> root, CriteriaQuery<?> criteriaQuery,
            CriteriaBuilder criteriaBuilder) {
          return criteriaBuilder.like(root.get("name"), "%" + name + "%" );
        }
    } ;
  }

  public Specification<Pokemon> typeContains(Long type) {

    return Objects.isNull(type) ? null : new Specification<Pokemon>() {
      @Override
      public Predicate toPredicate(Root<Pokemon> root, CriteriaQuery<?> criteriaQuery,
          CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.join("type", JoinType.LEFT).get("id"), type);
      }
    } ;
  }

  public Specification<Pokemon> baseStatusContains(String bs,Long bsv,Long bsj) {
    return Objects.isNull(bsj) | Objects.isNull(bsv) ? null : new Specification<Pokemon>() {
      @Override
      public Predicate toPredicate(Root<Pokemon> root, CriteriaQuery<?> criteriaQuery,
          CriteriaBuilder criteriaBuilder) {
        // bsjが0なら'以下'、1なら'以上'の種族値を持つポケモンを判定するSQLを生成する.
        if (bsj == 0) {
          return criteriaBuilder.lessThanOrEqualTo(root.get(bs), bsv );
        } else {
          return criteriaBuilder.greaterThanOrEqualTo(root.get(bs), bsv);
        }
      }
    } ;
  }


}
