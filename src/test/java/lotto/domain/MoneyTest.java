package lotto.domain;

import lotto.exception.NegativeMoneyException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {

    @Test
    @DisplayName("입력한 금액이 음수인 경우 예외를 반환한다")
    void NotEnoughMoneyTest() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(NegativeMoneyException.class);
    }

    @Test
    @DisplayName("금액을 가져온다")
    void getTest() {
        Money money = new Money(10000);

        assertThat(money.toDTO()
                .get())
                .isEqualTo(10000);
    }
}