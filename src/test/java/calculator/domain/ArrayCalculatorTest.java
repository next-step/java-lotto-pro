package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ArrayCalculatorTest {
    @Test
    @DisplayName("배열의 모든 값을 더한다")
    void sum() {
        PositiveNumber[] inputs = {PositiveNumber.of(1), PositiveNumber.of(2), PositiveNumber.of(3)};

        assertThat(ArrayCalculator.sum(inputs)).isEqualTo(6);
    }
}