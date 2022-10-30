package step3;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Money;
import step3.domain.Rank;
import step3.domain.Rate;

public class RateTest {

    @Test
    @DisplayName("이익이 0일때 수익률은 0이 나와야 한다.")
    void profitZeroTest() {
        Money money = new Money(10000);
        Rate rate = new Rate(money, 0);
        assertThat(rate.printRate()).isEqualTo("0.00");
    }

    @Test
    @DisplayName("수익률 매칭이 잘 되는지 확인한다.")
    void profitRateMatchingTest() {
        Money money = new Money(14000);
        assertThat(new Rate(money, 5000).printRate()).isEqualTo("0.35");
    }

}
