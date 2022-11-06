package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨금액")
class WinningMoneyTest {

    @DisplayName("일치 갯수가 3개이면 5_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {5000})
    void three_match(int winningMoney) {
        assertThat(WinningMoney.find(3, false).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 4개이면 50_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {50000})
    void four_match(int winningMoney) {
        assertThat(WinningMoney.find(4, false).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 5개이면 1_500_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500000})
    void five_match(int winningMoney) {
        assertThat(WinningMoney.find(5, false).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 5개이고 보너스 볼이 일치하면 30_000_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {30000000})
    void five_match_bonusBall_match(int winningMoney) {
        assertThat(WinningMoney.find(5, true).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 6개이면 2_000_000_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {2000000000})
    void six_match(int winningMoney) {
        assertThat(WinningMoney.find(6, false).getMoney()).isEqualTo(winningMoney);
    }
}
