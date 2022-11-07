package study.step4.models;

import org.junit.jupiter.api.Test;
import study.step4.exception.BonusBallNumberInWinningLottoException;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusBallTest {
    @Test
    void 보너스볼_생성() {
        assertThatNoException()
                .isThrownBy(() -> new BonusBall("3"));
    }

    @Test
    void 보너스볼_생성_예외() {
        WinningLotto winningLotto = new WinningLotto("1, 2, 3, 4, 5, 6");
        BonusBall bonusBall = new BonusBall("1");

        assertThatThrownBy(() -> bonusBall.validateNotInWinningLotto(winningLotto))
                .isInstanceOf(BonusBallNumberInWinningLottoException.class);
    }

    @Test
    void 보너스볼_값_비교() {
        BonusBall bonusBall = new BonusBall("3");
        assertThatNoException()
                .isThrownBy(() -> bonusBall.isEqualValue(new LottoNumber(3)));
    }
}
