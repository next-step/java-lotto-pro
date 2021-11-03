package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자열 계산기는")
public class StringCalculatorTest {
  @DisplayName("주어진 문자열에대해 합계를 계산한다.")
  @CsvSource({"'1,2', 3",
              "'2:3', 5",
              "'2,3:5', 10",
              "'//!\n1!5', 6",
              "'//!\n1!5!10', 16",
              "'//!\n1!5,7', 13",
              })
  @ParameterizedTest(name = "{index} => String Value [{0}] sumValue [{1}]")
  void calculate(String value, Integer expectedValue) {
    // given
    StringCalculator stringCalculator = new StringCalculator();

    // when
    Integer realValue = stringCalculator.calculate(value);

    // then
    assertThat(realValue).isEqualTo(expectedValue);
  }
}
