package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class WinningLottoTest {
    @Test
    void success_bonus_unique() {
        Lotto lotto = LottoFactory.manualGenerator("1,2,3,4,5,6");
        LottoNumber lottoNumber = LottoNumber.from(7);
        WinningLotto winningLotto = WinningLotto.of(lotto, lottoNumber);
        assertThat(winningLotto).isNotNull();
    }

    @Test
    void fail_bonus_unique() {
        Lotto lotto = LottoFactory.manualGenerator("1,2,3,4,5,6");
        LottoNumber lottoNumber = LottoNumber.from(1);
        assertThatThrownBy(() -> WinningLotto.of(lotto, lottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
