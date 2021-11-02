package stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 문자열에 입력된 숫자를 추출시 사용되는 구분자에대한 일급 컬렉션.
 */
public class Separators {
  private final List<Separator> items;

  public Separators(List<Separator> items) {
    this.items = new ArrayList<>(items);
  }

  public Separators(Separators separators) {
    this.items = new ArrayList<>(separators.items);
  }

  /**
   * 일급컬렉션에 저장된 구분자들을 가져온다.
   *
   * @return  문자열 결합된 구분자들
   */
  public String value() {
    return this.items.stream()
                      .map(Separator::value)
                      .reduce((result, seed) -> result += seed)
                      .orElse("");
  }

  public Boolean add(Separator separator) {
    return this.items.add(separator);
  }

}
