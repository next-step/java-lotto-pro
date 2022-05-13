package stringaddcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @Test
    void 문자열을_입력하여_숫자를_계산할_수_있다() {
        assertThat(StringAddCalculator.calculate("//;\n1;2;3")).isEqualTo(6);
        assertThat(StringAddCalculator.calculate("1,2,3")).isEqualTo(6);
    }
}
