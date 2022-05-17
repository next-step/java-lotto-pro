package lotto.domain;

import org.junit.jupiter.api.Test;

import static lotto.domain.LottoResult.isCriterionRate;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 수익률이_1을_초과() {
        assertThat(isCriterionRate(5000)).isTrue();
    }

    @Test
    void 수익률이_1에_미만() {
        assertThat(isCriterionRate(0.23)).isFalse();
    }
}
