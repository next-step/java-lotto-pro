package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGameTest {

    @DisplayName("로또 구입 실패")
    @Test
    void lotto_buy_failure() {
        LottoGame lottoGame = new LottoGame();
        Assertions.assertThatThrownBy(() -> lottoGame.buy(999))
                .isInstanceOf(IllegalArgumentException.class);
    }

}