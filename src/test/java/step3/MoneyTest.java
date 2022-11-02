package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.Money;

public class MoneyTest {

    @Test
    @DisplayName("구입금액이 0미만인 경우 예외가 발생해야 한다.")
    void moneyIsLessThanZero() {
        assertThatThrownBy(() -> new Money(-10))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(Money.LESS_THAN_MIN_SIZE);
    }

    @Test
    @DisplayName("양수를 입력하면 금액 객체가 생성된다.")
    void amountCreateSuccess() {
        Money money = new Money(1000);
        assertThat(money.getMoney()).isEqualTo(1000);
    }
}
