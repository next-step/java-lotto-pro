package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitRateTest {
    @Test
    void 이익이_0인_경우_수익률() {
        Money money = new Money("10000");

        ProfitRate rate = new ProfitRate(money, 0);
        assertThat(rate.printRate()).isEqualTo("0.00");
    }

    @Test
    void 수익률_매치_테스트() {
        Money money = new Money("14000");

        assertThat(new ProfitRate(money, 5000).printRate()).isEqualTo("0.35");
    }
}
