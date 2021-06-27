package work.upar.pokemon.form;

import lombok.Data;

/**
 * 検索条件を格納するform.
 */
@Data
public class PokemonForm {
  private Long id;
  private String name;

  private int h;
  private int a;
  private int b;
  private int c;
  private int d;
  private int s;

  private String type;
  private String type2;
}
