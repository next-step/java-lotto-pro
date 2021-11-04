package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorInputTest {
  @DisplayName("null 또는 공백 문자열 여부를 확인한다.")
  @ParameterizedTest
  @NullAndEmptySource
  void isNullOrEmpty(String nullAndEmptyInput) {
    String notNullAndEmptyInput = "2,3,4,5:1";
    CalculatorInput calculatorInput = new CalculatorInput(notNullAndEmptyInput);
    CalculatorInput nullAndEmptyCalculatorInput = new CalculatorInput(nullAndEmptyInput);

    assertThat(calculatorInput.isNullOrEmpty()).isFalse();
    assertThat(nullAndEmptyCalculatorInput.isNullOrEmpty()).isTrue();
  }

  @DisplayName("입력한 문자열이 숫자인지 확인한다.")
  @ParameterizedTest
  @CsvSource(value = {"2=true", "2e=false", "1234=true"}, delimiter = '=')
  void isNumber(String input, boolean expected) {
    CalculatorInput calculatorInput = new CalculatorInput(input);

    assertThat(calculatorInput.isNumber()).isEqualTo(expected);
  }

  @DisplayName("split 기능이 정상 작동되는지 확인한다.")
  @ParameterizedTest
  @CsvSource(value = {"2,3:4:5='2,3,4,5'", "1,5:3:1='1,5,3,1'"}, delimiter = '=')
  void split(String input, String expected) {
    CalculatorInput calculatorInput = new CalculatorInput(input);

    assertThat(calculatorInput.split()).containsExactly(expected.split(","));
  }
}