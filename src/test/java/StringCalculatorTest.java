import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {
    @Test
    @DisplayName("빈 문자열 혹은 null일 경우 0이 응답된다.")
    void checkEmptyOrNull() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.sum("")).isEqualTo(0);
        assertThat(stringCalculator.sum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("음수 혹은 숫자가 아닐 경우 RuntimeException 이 발생한다.")
    void checkInvalidInput() {
        StringCalculator stringCalculator = new StringCalculator();
        assertThatThrownBy(() -> {
            stringCalculator.sum("-3");
        }).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> {
            stringCalculator.sum("@");
        }).isInstanceOf(RuntimeException.class);
    }
}
