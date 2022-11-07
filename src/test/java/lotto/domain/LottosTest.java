package lotto.domain;

import lotto.fixture.WinningLottoFixture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Collections;

import static java.util.Arrays.asList;
import static lotto.fixture.LottosFixture.lottos;
import static lotto.fixture.WinningLottoFixture.winningLotto;
import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 집합")
class LottosTest {

    @DisplayName("로또 번호 6개 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"6, 1"})
    void six_match(int count, int expected) {
        assertThat(lottos().matchLottoCount(6, asList(false, true), winningLotto())).isEqualTo(expected);
    }

    @DisplayName("로또 번호 5개 일치, 보너스 볼 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"5, 1"})
    void five_match_and_bonus_ball_match(int count, int expected) {
        assertThat(lottos().matchLottoCount(count, Collections.singletonList(true), WinningLottoFixture.five_match_and_bonus_ball_match())).isEqualTo(expected);
    }

    @DisplayName("로또 번호 5개 일치하는 로또 집합 갯수")
    @ParameterizedTest
    @CsvSource({"5, 1"})
    void five_match(int count, int expected) {
        assertThat(lottos().matchLottoCount(count, Collections.singletonList(true), WinningLottoFixture.five_match())).isEqualTo(expected);
    }

    @DisplayName("수익률 계산")
    @ParameterizedTest
    @ValueSource(ints = {30000})
    void returnRate(double expected) {
        assertThat(lottos().returnRate(WinningLottoFixture.five_match())).isEqualTo(expected);
    }

}
