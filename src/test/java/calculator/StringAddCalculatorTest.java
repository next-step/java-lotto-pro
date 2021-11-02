package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "{displayName} - {arguments}")
    @NullAndEmptySource
    @DisplayName("빈 문자열 또는 null 값으로 더하면 0을 반환한다.")
    public void splitAndSum1(String input) {
        // when
        int result = StringAddCalculator.splitAndSum(input);

        // then
        assertThat(result).isEqualTo(0);
    }
}
