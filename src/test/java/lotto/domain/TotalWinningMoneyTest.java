package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.fixture.MatchCountFixture.matchCount;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 금액 총합")
class TotalWinningMoneyTest {

    @DisplayName("당첨 금액 총합 구하기")
    @ParameterizedTest
    @ValueSource(longs = {2_001_555_000})
    void sum(long expected) {
        assertThat(new TotalWinningMoney(matchCount()).sum()).isEqualTo(expected);
    }
}
