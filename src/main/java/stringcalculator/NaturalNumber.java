package stringcalculator;

/**
 * 계산에 사용되는 숫자.
 */
public class NaturalNumber {
  private Integer value;

  /**
   * 계산에 사용되는 숫자에대해 유효성검사를 하여 통과시 해당값을 저장.
   *
   * @param value 문자형으로 표현된 숫자
   */
  public NaturalNumber(String value) {
    checkValidation(value);

    this.value = Integer.valueOf(value);
  }

  private void checkValidation(String value) {
    try {
      checkNegativeValue(value);
    } catch (Exception exception) {
      throw new IllegalArgumentException("유요하지 않은 계산 숫자입니다.");
    }
  }

  private void checkNegativeValue(String value) {
    if (Integer.parseInt(value) < 0) {
      throw new IllegalArgumentException("유요하지 않은 계산 숫자입니다.");
    }
  }

  public Integer value() {
    return this.value;
  }

  /**
   * 자연수 덧셈.
   *
   * @param naturalNumber 덧셈할 자연수값
   * @return 자연수 구초제
   */
  public NaturalNumber add(NaturalNumber naturalNumber) {
    NaturalNumber newNaturalNumber = new NaturalNumber("0");

    newNaturalNumber.value = this.value + naturalNumber.value();

    return newNaturalNumber;
  }
}
