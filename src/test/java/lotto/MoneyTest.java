package lotto;

import lotto.domain.Money;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MoneyTest {
    @Test
    public void Money_생성() {
        Money money = Money.from(2000);
        assertThat(money.getCount()).isEqualTo(2);
    }

    @Test
    public void amount_negative() {
        assertThatThrownBy(() -> Money.from(-2000))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 잔액_존재() {
        assertThatThrownBy(() -> Money.from(2500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
