package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @DisplayName("빈 문자 or null 입력 테스트")
    @Test
    void splitAndSumNullOrEmptyText() {
        // given
        String text = "";
        // when
        int result = StringAddCalculator.splitAndSum(text);
        // then
        assertThat(result).isEqualTo(0);
    }
}
