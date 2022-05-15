package camp.nextstep.edu.common;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PositiveNumberTest {

    @Test
    void 양수가_아닌_숫자를_입력하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PositiveNumber(-1)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void 문자열_타입의_양수로_생성하면_정상_생성된다() {
        PositiveNumber positiveNumber = new PositiveNumber("123");
        assertThat(positiveNumber.getValue()).isEqualTo(123);
    }

    @Test
    void 숫자가_아닌_문자로_생성하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PositiveNumber("abc")).isInstanceOf(RuntimeException.class);
    }
}
