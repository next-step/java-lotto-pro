package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class NumberTests {

    @Test
    void 음수가_넘어올_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Number(-1))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력할 수 없습니다.");
    }

    @Test
    void 두_숫자를_더한다() {
        Number number1 = new Number(1);
        Number number2 = new Number(2);

        Number result = number1.plus(number2);
        assertThat(result).isEqualTo(new Number(3));
    }
}
