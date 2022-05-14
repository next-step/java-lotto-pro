package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTest {
    @Test
    void 머니가_0인_경우_수익률() {
        Money moneyIsZero = new Money("0");
        Profit profit= new Profit();

        profit.addProfit(5000);
        ProfitRate rate = new ProfitRate(moneyIsZero, profit);
        assertThat(rate.printRate()).isEqualTo("0.00");
    }

    @Test
    void 이익이_0인_경우_수익률() {
        Money money = new Money("10000");
        Profit profit= new Profit();

        ProfitRate rate = new ProfitRate(money, profit);
        assertThat(rate.printRate()).isEqualTo("0.00");
    }

    @Test
    void 머니와_이익이_0인_경우_수익률() {
        Money moneyIsZero = new Money("0");
        Profit profit= new Profit();

        ProfitRate rate = new ProfitRate(moneyIsZero, profit);
        assertThat(rate.printRate()).isEqualTo("0.00");
    }

    @Test
    void 수익률_프린트_테스트() {
        Money money = new Money("14000");
        Profit prifit = new Profit();
        prifit.addProfit(5000);

        assertThat(new ProfitRate(money, prifit).printRate()).isEqualTo("0.35");
    }
}
