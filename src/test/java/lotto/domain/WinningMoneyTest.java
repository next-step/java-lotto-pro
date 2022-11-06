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
        assertThat(WinningMoney.find(3).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 4개이면 50_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {50000})
    void four_match(int winningMoney) {
        assertThat(WinningMoney.find(4).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 5개이면 1_500_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {1500000})
    void five_match(int winningMoney) {
        assertThat(WinningMoney.find(5).getMoney()).isEqualTo(winningMoney);
    }

    @DisplayName("일치 갯수가 6개이면 2_000_000_000원을 수령한다.")
    @ParameterizedTest
    @ValueSource(ints = {2000000000})
    void six_match(int winningMoney) {
        assertThat(WinningMoney.find(6).getMoney()).isEqualTo(winningMoney);
    }
}
