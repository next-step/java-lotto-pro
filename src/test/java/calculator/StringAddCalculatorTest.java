package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자는 0을 반환한다.")
    @Test
    void splitAndSum_null_또는_빈문자() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력받은 경우 해당 숫자를 반환한다.")
    @ParameterizedTest(name = "숫자 {0}를 문자열로 입력받은 경우 {1} 숫자 반환한다.")
    @CsvSource(value = {"1:1", "2:2", "3:3", "15:15"}, delimiter = ':')
    void splitAndSum_숫자하나(String input, int expect) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "숫자 {0}를 컴마(,) 구분자로 입력할 경우 합 {1}을 반환한다.")
    @CsvSource(value = {"1,2:3", "2,2:4", "3,0:3", "15,15:30"}, delimiter = ':')
    void splitAndSum_쉼표구분자(String input, int expect) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }
}
