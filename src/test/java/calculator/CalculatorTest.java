package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class CalculatorTest {
    private Calculator calculator = new Calculator();
    @Test
    public void sum_normal() {
        int result = calculator.sum(new Numbers(new String[]{"1", "2", "3"}));
        assertThat(result).isEqualTo(6);
    }
    @Test
    public void sum_negative() {
        assertThatThrownBy(() -> calculator.sum(new Numbers(new String[]{"-1", "2", "3"})))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void sum_일반문자() {
        assertThatThrownBy(() -> calculator.sum(new Numbers(new String[]{"a", "b", "ㄱ"})))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void sum_특수문자() {
        assertThatThrownBy(() -> calculator.sum(new Numbers(new String[]{"*", "/", "+"})))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
