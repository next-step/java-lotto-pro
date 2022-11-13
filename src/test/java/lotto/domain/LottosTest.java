package lotto.domain;

import lotto.fixture.LottosFixture;
import lotto.fixture.WinningLottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.fixture.LottosFixture.lottos;
import static lotto.fixture.WinningLottoFixture.threeMatch;
import static lotto.fixture.WinningLottoFixture.winningLotto;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 집합")
class LottosTest {

    @DisplayName("로또 번호 6개 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"SIX_MATCH, 1"})
    void sixMatch(WinningMoney winningMoney, int expected) {
        assertThat(lottos().matchLottoCount(winningMoney, winningLotto())).isEqualTo(expected);
    }

    @DisplayName("로또 번호 5개 일치, 보너스 볼 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"FIVE_MATCH_AND_BONUS_BALL_MATCH, 1"})
    void fiveMatchAndBonusBallMatch(WinningMoney winningMoney, int expected) {
        assertThat(lottos().matchLottoCount(winningMoney, WinningLottoFixture.fiveMatchAndBonusBallMatch())).isEqualTo(expected);
    }

    @DisplayName("로또 번호 5개 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"FIVE_MATCH, 1"})
    void fiveMatch(WinningMoney winningMoney, int expected) {
        assertThat(lottos().matchLottoCount(winningMoney, WinningLottoFixture.fiveMatch())).isEqualTo(expected);
    }
}
