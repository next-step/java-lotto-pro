package stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 계산에서 사용되는 숫자에대한 일급컬렉션.
 */
public class NaturalNumbers {
  private final List<NaturalNumber> items;
     
  public NaturalNumbers(List<NaturalNumber> items) {
    this.items = new ArrayList<>(items);
  }

  /**
   * 저장된 숫자들의 합계를 계산한다.
   *
   * @return 계산된 합계
   */
  public Integer sum() {
    return items.stream().reduce((result, seed) -> result.add(seed))
                          .map(NaturalNumber::value)
                          .orElse(0);
  }

}
