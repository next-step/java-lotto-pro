package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SumOfOperandsTest {
    @Test
    @DisplayName("0 + 0 = 0")
    void case1() {
        final Operand[] operands = { new Operand("0"), new Operand("0") };
        final SumOfOperands sumOfOperands = new SumOfOperands(operands);
        final int sumResult = sumOfOperands.result();
        assertThat(sumResult).isEqualTo(0);
    }

    @Test
    @DisplayName("1 + 2 + 3 + 4 = 10")
    void case2() {
        final Operand[] operands = {
                new Operand("1"),
                new Operand("2"),
                new Operand("3"),
                new Operand("4"),
        };
        final SumOfOperands sumOfOperands = new SumOfOperands(operands);
        final int sumResult = sumOfOperands.result();
        assertThat(sumResult).isEqualTo(10);
    }
}
