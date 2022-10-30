package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoMoneyTest {
    @Test
    void 구입금액에_따라_갯수를_계산한다() {
        assertThat(new LottoMoney(14000).count()).isEqualTo(14);
        assertThat(new LottoMoney(1200).count()).isEqualTo(1);
        assertThat(new LottoMoney(1999).count()).isEqualTo(1);
        assertThat(new LottoMoney(2000).count()).isEqualTo(2);
        assertThatThrownBy(() -> new LottoMoney(900))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoMoney(0))
            .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new LottoMoney(-100))
            .isInstanceOf(IllegalArgumentException.class);
    }

}