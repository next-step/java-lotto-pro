package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringAddCalculatorTest {

    @Test
    @DisplayName("입력값이 null이거나 빈 문자열일 경우 0을 반환")
    void inputNullOrBlank() {
        int blankString1 = StringAddCalculator.input("");
        int blankString2 = StringAddCalculator.input(" ");
        int nullString = StringAddCalculator.input(null);

        assertAll(
                () -> assertThat(blankString1).isZero(),
                () -> assertThat(blankString2).isZero(),
                () -> assertThat(nullString).isZero()
        );
    }
}
