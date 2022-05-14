package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    @DisplayName("배열에 문자열 하나만 있을 경우")
    public void checkOneSource() {
        calculator = new Calculator(new String[]{"1"});
        assertThat(calculator.sum()).isEqualTo(1);
    }

    @Test
    @DisplayName("더하기 정상 동작 테스트")
    public void sum() {
        String[] target = {"1", "2", "3"};
        calculator = new Calculator(target);
        assertThat(calculator.sum()).isEqualTo(6);
    }
}
