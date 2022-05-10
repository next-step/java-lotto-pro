package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자는 0을 반환한다.")
    @Test
    void splitAndSum_null_또는_빈문자() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0)
        );
    }
}
