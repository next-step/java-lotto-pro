package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoChargeTest {
    @ParameterizedTest
    @CsvSource(value = {"5000,5", "14000,14"})
    void 구입금액_개수(int charge, int expected) {
        assertThat(LottoCharge.from(charge).count()).isEqualTo(expected);
    }

    @Test
    void 구입금액_0보다큰수() {
        assertThatThrownBy(() -> LottoCharge.from(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구입금액_1000의배수() {
        assertThatThrownBy(() -> LottoCharge.from(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수익률_계산() {
        assertThat(LottoCharge.from(14000).revenueRate(5000)).isEqualTo(0.35);
    }
}
