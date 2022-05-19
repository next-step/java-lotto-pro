package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class LottoCountTest {
    @Test
    @DisplayName("LottoCount가 생성되는지")
    void create_success() {
        LottoCount lottoCount = LottoCount.from(2);

        assertThat(lottoCount.getCount()).isEqualTo(2);
    }

    @Test
    @DisplayName("LottoCount minus가 작동하는지")
    void minus_success() {
        LottoCount lottoCountBigger = LottoCount.from(3);
        LottoCount lottoCountSmaller = LottoCount.from(2);

        assertThat(lottoCountBigger.minus(lottoCountSmaller).getCount()).isEqualTo(1);
    }
}
