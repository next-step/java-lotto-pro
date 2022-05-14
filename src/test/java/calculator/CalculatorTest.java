package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    @DisplayName("배열에 문자열 하나만 있을 경우")
    public void checkOneSource() {
        calculator = new Calculator(new String[]{"1"});
        assertThat(calculator.sum()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 값이 배열에 있을 경우")
    public void checkNotNumber() {
        String[] target = {"1", "a", "b"};
        assertThatThrownBy(() -> calculator = new Calculator(target)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("음수가 배열에 있을 경우")
    public void checkNegativeNumber() {
        String[] target = {"1", "-3", "-5"};
        assertThatThrownBy(() -> calculator = new Calculator(target)).isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("더하기 정상 동작 테스트")
    public void sum() {
        String[] target = {"1", "2", "3"};
        calculator = new Calculator(target);
        assertThat(calculator.sum()).isEqualTo(6);
    }
}
