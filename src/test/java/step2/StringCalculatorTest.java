package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    @Test
    @DisplayName("null 또는 비어있다면 0이어야한다.")
    void ifNullOrEmptyResultZero() {
        StringCalculator calculator = new StringCalculator("");
        assertThat(calculator.result()).isEqualTo(0);
        calculator = new StringCalculator(null);
        assertThat(calculator.result()).isEqualTo(0);
    }
}
