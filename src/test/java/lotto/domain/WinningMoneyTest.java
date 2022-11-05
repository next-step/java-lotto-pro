package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 금액 계산기")
class WinningMoneyTest {

    @DisplayName("일치갯수가 4개이고 로또갯수가 3개일때 당첨금액을 구한다.")
    @ParameterizedTest
    @CsvSource({"4,3,150000"})
    void fourMatchMoney(int matchCount, int lottoCount, long expected) {
        assertThat(new WinningMoney(new Count(matchCount), new Count(lottoCount)).calculate()).isEqualTo(expected);
    }

    @DisplayName("일치갯수가 3개이고 로또갯수가 3개일때 당첨금액을 구한다.")
    @ParameterizedTest
    @CsvSource({"3,3,15000"})
    void threeMatchMoney(int matchCount, int lottoCount, long expected) {
        assertThat(new WinningMoney(new Count(matchCount), new Count(lottoCount)).calculate()).isEqualTo(expected);
    }

    @DisplayName("일치갯수가 5개이고 로또갯수가 2개일때 당첨금액을 구한다.")
    @ParameterizedTest
    @CsvSource("5,2,3000000")
    void fiveMatchMoney(int matchCount, int lottoCount, long expected) {
        assertThat(new WinningMoney(new Count(matchCount), new Count(lottoCount)).calculate()).isEqualTo(expected);
    }

    @DisplayName("일치갯수가 6개이고 로또갯수가 2개일때 당첨금액을 구한다.")
    @ParameterizedTest
    @CsvSource({"6, 2, 4000000000"})
    void sixMatchMoney(int matchCount, int lottoCount, long expected) {
        assertThat(new WinningMoney(new Count(matchCount), new Count(lottoCount)).calculate()).isEqualTo(expected);
    }
}
