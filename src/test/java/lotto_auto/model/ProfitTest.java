package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProfitTest {
    @Test
    void append_수익() {
        Profit profit = new Profit();
        profit.addProfit(5000);

        assertThat(profit.getProfit()).isEqualTo(5000);
    }
}
