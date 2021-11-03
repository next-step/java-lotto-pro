import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @DisplayName("빈 문자열 or null 일경우 0으로 리턴하는 기능 테스트")
    @Test
    public void nullOrEmptyString_ReturnZeroTest() {
        assertThat(calculator.calculate("")).isEqualTo(0);
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @DisplayName("문자열(숫자)을 숫자로 변환하는 기능 테스트")
    @Test
    public void stringToIntTest() {
        assertThat(calculator.calculate("1")).isEqualTo(1);
    }

    @DisplayName("문자열(숫자가 아닌 or 음수)을 숫자로 변환할 시 예외 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"TEST", "-1"})
    public void stringToInt_ThrowExceptionTest(String fixture) {
        assertThatThrownBy(() -> calculator.calculate(fixture)).isInstanceOf(IllegalArgumentException.class);
    }
}
