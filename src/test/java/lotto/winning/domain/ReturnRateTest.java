package lotto.winning.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.lotto.domain.LottoMoneyFixture.로또구매금액_10_000;
import static lotto.winning.domain.TotalWinningMoneyFixture.당첨금액_5000;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률")
class ReturnRateTest {

    @DisplayName("수익률 계산")
    @Test
    void name() {
        ReturnRate returnRate = new ReturnRate(로또구매금액_10_000(), 당첨금액_5000());
        assertThat(returnRate.calculate()).isEqualTo(0.5);
    }
}
