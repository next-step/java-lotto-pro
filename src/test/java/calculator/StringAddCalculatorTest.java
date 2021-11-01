package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("null 또는 빈 문자일 경우 0을 반환")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "5", "9"})
    void splitAndSum_숫자하나(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

}
