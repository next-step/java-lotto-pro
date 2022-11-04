package lotto.winning.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.lotto.domain.fixture.LottoMoneyFixture.로또구매금액_10_000;
import static lotto.winning.fixture.TotalWinningMoneyFixture.당첨금액_5000;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("수익률")
class ReturnRateTest {

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(doubles = {0.5})
    void name(double expected) {
        assertThat(new ReturnRate(로또구매금액_10_000(), 당첨금액_5000()).calculate()).isEqualTo(expected);
    }
}
