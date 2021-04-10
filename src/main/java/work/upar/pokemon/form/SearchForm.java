package work.upar.pokemon.form;

import lombok.Data;

@Data
public class SearchForm {
  private String name;
  private Long type;
  private String baseStatus;
  private Long baseStatusValue;
  private Long baseStatusJudge;
}
