package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.BonusBallNumberInWinningLottoException;
import study.step4.exception.LottoInvalidSizeException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class WinningLottoTest {
    @Test
    void 당첨번호_생성() {
        assertThatNoException()
                .isThrownBy(() -> new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6"), new LottoNumber("7")));
    }

    @Test
    void 당첨번호_생성_예외() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6, 7"), new LottoNumber("8")))
                .isInstanceOf(LottoInvalidSizeException.class);
        assertThatThrownBy(() -> new WinningLotto(new Lotto("1, 2, 3, 4, 5"), new LottoNumber("6")))
                .isInstanceOf(LottoInvalidSizeException.class);;
    }

    @Test
    void 보너스볼_생성_예외() {
        assertThatThrownBy(() -> new WinningLotto(new Lotto("1, 2, 3, 4, 5, 6"), new LottoNumber("1")))
                .isInstanceOf(BonusBallNumberInWinningLottoException.class);
    }
}
