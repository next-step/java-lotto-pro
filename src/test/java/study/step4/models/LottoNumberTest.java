package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.LottoNumberOutOfRangeException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    void 로또_숫자_유효성_검사_정상() {
        assertThatNoException().isThrownBy(() -> new LottoNumber(3));
    }

    @Test
    void 로또_숫자_유효성_검사_예외() {
        assertThatThrownBy(() -> new LottoNumber(0))
                .isInstanceOf(LottoNumberOutOfRangeException.class);
        assertThatThrownBy(() -> new LottoNumber(46))
                .isInstanceOf(LottoNumberOutOfRangeException.class);
    }
}
