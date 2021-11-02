package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("빈 문자열이나 null 입력시 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void inputNullOrEmptyString(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }


}