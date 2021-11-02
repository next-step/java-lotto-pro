package stringcalculator;

/**
 * 문자열을 입력하면 숫자를 파싱하여 계산한다.
 */
public class StringCalculator {
  StringCalculatorParsor stringCalculratorParsor;

  public StringCalculator() {
    this.stringCalculratorParsor = new StringCalculatorParsor();
  }

  /**
   * 문자열에 있는 숫자에대해 계산을 한다.
   *
   * @param calcuratingString 파싱에 사용될 문자열
   * @return 계산을 한 결과값
   */
  public Integer calculate(String calcuratingString) {
    CalculatorNumbers calculatorNumbers  = this.stringCalculratorParsor.parse(calcuratingString);

    return calculatorNumbers.sum();
  }
}
