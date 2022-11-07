package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.LottoInvalidSizeException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 당첨번호_생성() {
        assertThatNoException()
                .isThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 6"));
    }

    @Test
    void 당첨번호_생성_예외() {
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5, 6, 7"))
                .isInstanceOf(LottoInvalidSizeException.class);
        assertThatThrownBy(() -> new WinningLotto("1, 2, 3, 4, 5"))
                .isInstanceOf(LottoInvalidSizeException.class);;
    }
}
