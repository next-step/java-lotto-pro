package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환한다.")
    void splitAndSum_empty_or_null(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        Assertions.assertThat(result).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "10:10", "100:100"}, delimiter = ':')
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    void splitAndSum_single_number(String input, int expected) {
        int result = StringAddCalculator.splitAndSum(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("쉼표(,)를 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void splitAndSumByCommaDelimiter() {
        int result = StringAddCalculator.splitAndSum("1,2");

        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준을 분리한 각 숫자의 합을 반환한다.")
    void splitAndSumByColonDelimiter() {
        int result = StringAddCalculator.splitAndSum("1:2");

        Assertions.assertThat(result).isEqualTo(3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2,3", "1,2:3"})
    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void splitAndSumByDefaultDelimiter(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자(//와 \n 사이에 위치하는 문자)를 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    void splitAndSum_custom_delimiter_test() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        Assertions.assertThat(result).isEqualTo(6);
    }
}
