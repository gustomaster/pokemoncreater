package work.upar.pokemon.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

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
    
    @ManyToOne
    private Type type;

}
