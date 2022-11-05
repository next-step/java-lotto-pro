package lotto.domain;

import lotto.fixture.LottosFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.fixture.WinningNumberFixture.당첨번호45691011;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통계")
class StatisticsTest {

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void returnRate(double expected) {
        assertThat(new Statistics(LottosFixture.lottos(), 당첨번호45691011()).returnRate()).isEqualTo(expected);
    }
}
