package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class MoneyTest {
    @Test
    @DisplayName("구매금액 3500원으로 구매가능한 수량은 3이다")
    void purchasableQuantity() {
        assertThat(new Money(3500).getQuantity()).isEqualTo(3);
    }

    @Test
    @DisplayName("구입금액이 1000원 이하로 입력되면 예외가 발생한다")
    void lessThen_1000() {
        assertThatIllegalArgumentException().isThrownBy(() -> new Money(999)).withMessage("금액이 부족합니다.(최소필요금액: 1000)");
    }

}
