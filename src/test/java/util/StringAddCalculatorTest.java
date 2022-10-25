package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자가 입력될 경우 0이 반환되어야 한다")
    public void splitAndSum_return_zero_if_null_or_emptyString(String text) {

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }
}