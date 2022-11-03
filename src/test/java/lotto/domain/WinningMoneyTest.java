package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class WinningMoneyTest {
    @Test
    @DisplayName("14개의 로또 중 하나만 3개를 맞추면 수익률이 0.35가 반환됨")
    void test1() {
        WinningMoney winningMoney = new WinningMoney(Arrays.asList(Rank.FIFTH));

        assertThat(winningMoney.calcYield(Money.of(14000))).isEqualTo(0.35);
    }

    @Test
    @DisplayName("구입 금액을 입력하고 3개를 맞춘 갯수만큼 수익률이 계산됨")
    void test2() {
        WinningMoney winningMoney = new WinningMoney(Arrays.asList(Rank.FIFTH,Rank.FIFTH));

        assertThat(winningMoney.calcYield(Money.of(10000))).isEqualTo(1);
    }

    @Test
    void count() {
        WinningMoney winningMoney = new WinningMoney(Arrays.asList(Rank.FIFTH,Rank.FIFTH));

        assertThat(winningMoney.count(Rank.FIRST)).isEqualTo(0);
    }

    @Test
    void count2() {
        WinningMoney winningMoney = new WinningMoney(Arrays.asList(Rank.FIFTH,Rank.FIFTH));

        assertThat(winningMoney.count(Rank.FIFTH)).isEqualTo(2);
    }
}