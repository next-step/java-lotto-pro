package lotto.domain;

import lotto.fixture.LottosFixture;
import lotto.fixture.WinningLottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.fixture.LottosFixture.lottos;
import static lotto.fixture.WinningLottoFixture.winningLotto;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 집합")
class LottosTest {

    @DisplayName("로또 번호 6개 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"SIX_MATCH, 1"})
    void six_match(WinningMoney winningMoney, int expected) {
        assertThat(lottos().matchLottoCount(winningMoney, winningLotto())).isEqualTo(expected);
    }

    @DisplayName("로또 번호 5개 일치, 보너스 볼 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"FIVE_MATCH_AND_BONUS_BALL_MATCH, 1"})
    void five_match_and_bonus_ball_match(WinningMoney winningMoney, int expected) {
        assertThat(lottos().matchLottoCount(winningMoney, WinningLottoFixture.five_match_and_bonus_ball_match())).isEqualTo(expected);
    }

    @DisplayName("로또 번호 5개 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"FIVE_MATCH, 1"})
    void five_match(WinningMoney winningMoney, int expected) {
        assertThat(lottos().matchLottoCount(winningMoney, WinningLottoFixture.five_match())).isEqualTo(expected);
    }

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(ints = {1500})
    void return_rate(double expected) {
        assertThat(lottos().returnRate(WinningLottoFixture.five_match())).isEqualTo(expected);
    }

    @DisplayName("수익률 계산이 소수점 두자리로 제한")
    @ParameterizedTest
    @ValueSource(doubles = {1.67})
    void point(double expected) {
        assertThat(LottosFixture.point().returnRate(WinningLottoFixture.threeMatch())).isEqualTo(expected);
    }
}
