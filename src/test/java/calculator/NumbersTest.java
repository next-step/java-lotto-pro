package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumbersTest {
    @Test
    @DisplayName("합을 계산한다.")
    void sum_test() {
        String[] inputs = {"1", "2", "3"};
        Numbers numbers = Numbers.of(inputs);
        assertThat(numbers.getTotalSum()).isEqualTo(6);
    }
}
