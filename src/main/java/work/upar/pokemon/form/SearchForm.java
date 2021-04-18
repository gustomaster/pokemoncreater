package work.upar.pokemon.form;

import lombok.Data;

@Data
public class SearchForm {
  // ポケモンの名前
  private String name;
  // ポケモンのタイプ
  private Long type;
  // 種族値の分類(h=HP, a=攻撃, b=防御, c=特攻, d=特防 s=素早さ)
  private String baseStatus;
  // 種族値の値
  private Long baseStatusValue;
  // 種族値の判定(0=以下, 1=以上)
  private Long baseStatusJudge;
}
