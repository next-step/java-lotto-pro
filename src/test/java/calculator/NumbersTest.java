package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    @DisplayName("숫자 하나 입력")
    @Test
    void inputNumberSingle() {
        // given
        Numbers numbers = new Numbers(Arrays.asList(new Number("1")));
        // when
        int result = numbers.getSum();
        // then
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("숫자 여러개 입력")
    @Test
    void inputNumberMultiple() {
        // given
        Numbers numbers = new Numbers(Arrays.asList(new Number("1"), new Number("2")));
        // when
        int result = numbers.getSum();
        // then
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("잘못된 숫자 입력 예외")
    @Test
    void inputWrongNumber() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(Arrays.asList(new Number("a"), new Number("2")));
            int result = numbers.getSum();
        }).isInstanceOf(NumberFormatException.class)
        .hasMessageContaining("입력한 숫자를 확인해 주세요.");
    }

    @DisplayName("음수 입력 예외")
    @Test
    void inputNegativeNumber() {
        assertThatThrownBy(() -> {
            Numbers numbers = new Numbers(Arrays.asList(new Number("-1"), new Number("2")));
            int result = numbers.getSum();
        }).isInstanceOf(NegativeNumberException.class)
                .hasMessageContaining("입력된 숫자가 0 미만입니다.");
    }
}
