package stringcalculator;

import java.util.ArrayList;
import java.util.List;

/**
 * 계산에서 사용되는 숫자에대한 일급컬렉션.
 */
public class CalculatorNumbers {
  private final List<CalculatorNumber> items;
     
  public CalculatorNumbers(List<CalculatorNumber> items) {
    this.items = new ArrayList<>(items);
  }

  /**
   * 저장된 숫자들의 합계를 계산한다.
   *
   * @return 계산된 합계
   */
  public Integer sum() {
    return items.stream().map(CalculatorNumber::value)
                          .reduce((result, seed) -> result += seed)
                          .orElse(0);
  }

}
