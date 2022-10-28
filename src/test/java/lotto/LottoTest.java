package lotto;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;

class LottoTest {
    @Test
    void 구입금액에_따라_갯수를_계산한다() {
        assertThat(new Lotto(14000).getPurchaseLottoList()).hasSize(14);
        assertThat(new Lotto(1200).getPurchaseLottoList()).hasSize(1);
        assertThat(new Lotto(1999).getPurchaseLottoList()).hasSize(1);
        assertThat(new Lotto(2000).getPurchaseLottoList()).hasSize(2);
        assertThatThrownBy(() -> new Lotto(900))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Lotto(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }
}