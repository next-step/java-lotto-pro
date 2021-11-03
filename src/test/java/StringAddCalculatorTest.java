import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {

    @DisplayName("빈 문자열 or null 일경우 0으로 리턴")
    @Test
    public void nullOrEmptyString_ReturnZeroTest() {

        StringAddCalculator calculator = new StringAddCalculator();
        assertThat(calculator.calculate("")).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }
}
