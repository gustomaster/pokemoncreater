package work.upar.pokemon.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

/**
 * ポケモンEntity.
 */
@Getter
@Setter
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int h;
    private int a;
    private int b;
    private int c;
    private int d;
    private int s;

    // 論理削除フラグ
    private boolean isDeleted;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Type2 type2;

}
