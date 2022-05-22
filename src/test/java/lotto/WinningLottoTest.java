package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WinningLottoTest {
    @Test
    void success_bonus_unique() {
        Lotto lotto = LottoFactory.manualGenerator("1,2,3,4,5,6");
        LottoNumber lottoNumber = new LottoNumber(7);
        WinningLotto winningLotto = new WinningLotto(lotto, lottoNumber);
    }

    @Test
    void fail_bonus_unique() {
        Lotto lotto = LottoFactory.manualGenerator("1,2,3,4,5,6");
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThatThrownBy(() -> new WinningLotto(lotto, lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
