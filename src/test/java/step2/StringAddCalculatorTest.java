package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("null은 0을 반환")
    public void Null_return_zero() {
        assertThat(calculator.calculate(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("공백은 0을 반환")
    public void Blank_return_zero() {
        assertThat(calculator.calculate("")).isEqualTo(0);
    }

}