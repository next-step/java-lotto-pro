package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {

    @Test
    void 빈문자열이나_null_입력시_0_반환() {
        Assertions.assertThat(StringAddCalculator.calculate("")).isEqualTo(0);
        Assertions.assertThat(StringAddCalculator.calculate(null)).isEqualTo(0);
    }
}