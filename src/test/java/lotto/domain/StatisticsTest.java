package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.fixture.LottosFixture.lottos;
import static lotto.fixture.WinningNumberFixture.winningNumber_one;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("통계")
class StatisticsTest {

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void returnRate(double expected) {
        assertThat(new Statistics(lottos(), winningNumber_one()).returnRate()).isEqualTo(expected);
    }

    @DisplayName("일치 횟수를 만족하는 로또의 갯수를 구한다.")
    @ParameterizedTest
    @ValueSource(ints = {1})
    void lottoCount(int expected) {
        assertThat(new Statistics(lottos(), winningNumber_one()).lottosMap().get(3).getLottos()).hasSize(expected);
    }
}
