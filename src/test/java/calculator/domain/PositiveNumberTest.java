package calculator.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositiveNumberTest {
    @Test
    void 음수_예외() {
        String input = "-1";
        assertThatThrownBy(() -> PositiveNumber.of(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자가_아닌_값_예외() {
        String input = "a";
        assertThatThrownBy(() -> PositiveNumber.of(input)).isInstanceOf(IllegalArgumentException.class);
    }
}