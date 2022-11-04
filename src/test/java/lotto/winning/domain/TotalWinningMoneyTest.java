package lotto.winning.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.winning.fixture.MatchCountFixture.*;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 금액 총합")
class TotalWinningMoneyTest {

    @DisplayName("당첨 금액 총합 구하기")
    @Test
    void sum() {
        TotalWinningMoney totalWinningMoney = new TotalWinningMoney(matchCount());
        assertThat(totalWinningMoney.sum()).isEqualTo(2_001_555_000);
    }
}
