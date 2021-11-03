package stringcalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("문자열계산기의 파서가 ")
public class ParserTest {
  @DisplayName("숫자와 기본 구분자로 구성된 문자열을 받을시 합계가 계산된다.")
  @CsvSource({"'1,2', 3",
              "'4:5', 9",
              "'4:5:1', 10",
              "'3,4:5:1', 13"
            })
  @ParameterizedTest(name = "{index} => String Value [{0}] sumValue [{1}]")
  void getCalculatorNumber(String value, Integer expectedValue) {
    // given
    Parser stringParser = new Parser();

    // when
    NaturalNumbers realCalculatorNumbers = stringParser.parse(value);

    // then
    assertThat(realCalculatorNumbers.sum()).isEqualTo(expectedValue);
  }

  @DisplayName("숫자와 커스텀 구분자로 구성된 문자열을 받을시 합계가 계산된다.")
  @CsvSource({"'//|\n1|2', 3",
              "'//[\n4[5', 9",
              "'//|\n4,5|1', 10"
            })
  @ParameterizedTest(name = "{index} => String Value [{0}] sumValue [{1}]")
  void getCalculatorNumber_custrom(String value, Integer expectedValue) {
    // given
    Parser stringParser = new Parser();

    // when
    NaturalNumbers realCalculatorNumbers = stringParser.parse(value);

    // then
    assertThat(realCalculatorNumbers.sum()).isEqualTo(expectedValue);
  }
}
