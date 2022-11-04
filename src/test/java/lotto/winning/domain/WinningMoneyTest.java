package lotto.winning.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 금액 계산기")
class WinningMoneyTest {

    @DisplayName("일치갯수가 3개이고 로또갯수가 3개일때 당첨금액을 구한다.")
    @Test
    void threeMatchMoney() {
        WinningMoney calculator = new WinningMoney(3, 3);
        assertThat(calculator.calculate()).isEqualTo(15_000);
    }

    @DisplayName("일치갯수가 4개이고 로또갯수가 3개일때 당첨금액을 구한다.")
    @Test
    void fourMatchMoney() {
        WinningMoney calculator = new WinningMoney(4, 3);
        assertThat(calculator.calculate()).isEqualTo(150_000);
    }

    @DisplayName("일치갯수가 5개이고 로또갯수가 2개일때 당첨금액을 구한다.")
    @Test
    void fiveMatchMoney() {
        WinningMoney calculator = new WinningMoney(5, 2);
        assertThat(calculator.calculate()).isEqualTo(3_000_000);
    }

    @DisplayName("일치갯수가 6개이고 로또갯수가 2개일때 당첨금액을 구한다.")
    @Test
    void sixMatchMoney() {
        WinningMoney calculator = new WinningMoney(6, 2);
        assertThat(calculator.calculate()).isEqualTo(4_000_000_000L);
    }
}
