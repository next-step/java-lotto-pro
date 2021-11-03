package stringcalculator;

/**
 * 계산에 사용되는 숫자.
 */
public class Number {
  private final Integer item;
  
  /**
   * 계산에 사용되는 숫자에대해 유효성검사를 하여 통과시 해당값을 저장.
   *
   * @param value 문자형으로 표현된 숫자
   */
  public Number(String value) {
    if (isInvalid(value)) {
      throw new RuntimeException("유요하지 않은 계산 숫자입니다.");
    }

    item = Integer.valueOf(value);
  }

  public Integer value() {
    return item;
  }

  private boolean isInvalid(String value) {
    try {
      if (isNegative(value)) {
        return true;
      }
    } catch (Exception exception) {
      return true;
    }
    
    return false;
  }

  private boolean isNegative(String value) {
    return Integer.parseInt(value) < 0;
  }
}
