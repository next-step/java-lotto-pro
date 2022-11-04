package lotto.winning.domain;

import lotto.lotto.domain.LottoMoney;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.lotto.domain.fixture.LottoMoneyFixture.로또구매금액_10_000;
import static lotto.winning.domain.ReturnRate.LOTTO_MONEY_EXCEPTION_MESSAGE;
import static lotto.winning.domain.ReturnRate.TOTAL_WINNING_MONEY_EXCEPTION_MESSAGE;
import static lotto.winning.fixture.TotalWinningMoneyFixture.당첨금액_5000;
import static org.assertj.core.api.Assertions.*;

@DisplayName("수익률")
class ReturnRateTest {

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(doubles = {0.5})
    void name(double expected) {
        assertThat(new ReturnRate(로또구매금액_10_000(), 당첨금액_5000()).calculate()).isEqualTo(expected);
    }

    @DisplayName("수익률 생성")
    @Test
    void constructor() {
        assertThatNoException().isThrownBy(() -> new ReturnRate(로또구매금액_10_000(), 당첨금액_5000()));
    }

    @DisplayName("로또 금액 not null")
    @ParameterizedTest
    @NullSource
    void lottoMoney_null(LottoMoney lottoMoney) {
        assertThatThrownBy(() -> new ReturnRate(lottoMoney, 당첨금액_5000()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(LOTTO_MONEY_EXCEPTION_MESSAGE);
    }

    @DisplayName("당첨 금액 not null")
    @ParameterizedTest
    @NullSource
    void totalWinningMoney_null(TotalWinningMoney totalWinningMoney) {
        assertThatThrownBy(() -> new ReturnRate(로또구매금액_10_000(), totalWinningMoney))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(TOTAL_WINNING_MONEY_EXCEPTION_MESSAGE);
    }
}
