package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환테스트")
    @ParameterizedTest
    @CsvSource({"1,1"})
    public void splitAndSum_숫자하나(String input, int expected) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String input, int expected) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }
}
