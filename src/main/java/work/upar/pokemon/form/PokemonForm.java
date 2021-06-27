package work.upar.pokemon.form;

import lombok.Data;

/**
 * ポケモンの編集情報を格納するform.
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
