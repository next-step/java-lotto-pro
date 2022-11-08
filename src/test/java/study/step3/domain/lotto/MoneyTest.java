package study.step3.domain.lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    @DisplayName("주어진 금액을 합산하여 반환한다")
    void plus_money_test() {
        Money money = Money.of(1000L);
        assertThat(money.plus(Money.of(1000L))).isEqualTo(Money.of(2000L));
    }
}
