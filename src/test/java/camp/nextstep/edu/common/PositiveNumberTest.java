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
        PositiveNumber positiveNumber = new PositiveNumber("123", false);
        assertThat(positiveNumber.getValue()).isEqualTo(123);
    }

    @Test
    void 문자열_타입의_양수로_양수_객체를_생성할_때_null_또는_빈값일_때_0_으로_변환_옵션에_따라_정상동작_또는_예외가_발생해야_한다() {
        assertThatNoException().isThrownBy(() -> new PositiveNumber("", true));
        assertThatThrownBy(() -> new PositiveNumber("", false))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 숫자가_아닌_문자로_생성하면_예외가_발생한다() {
        assertThatThrownBy(() -> new PositiveNumber("abc", false))
                .isInstanceOf(RuntimeException.class);
    }
}
