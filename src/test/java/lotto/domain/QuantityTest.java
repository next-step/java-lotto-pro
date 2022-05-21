package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTest {
    @Test
    @DisplayName("구매가능3, 수동 구매수량2 라면 True 를 반환한다")
    void isPurchasableTrue() {
        assertThat(new Quantity(3, 2).isPurchasable()).isTrue();
    }

    @Test
    @DisplayName("구매가능3, 수동 구매수량3 이라면 False 를 반환한다")
    void isPurchasableFalse() {
        assertThat(new Quantity(3, 3).isPurchasable()).isFalse();
    }

    @Test
    @DisplayName("구매가능 수량 3을 초과하면 예외가 발생한다")
    void increaseException() {
        Quantity quantity = new Quantity(3, 3);
        assertThatIllegalArgumentException().isThrownBy(quantity::increase)
                .withMessage("구매할 수 있는 수량을 초과하였습니다. 구매가능수량: 3, 구매수량:4");
    }
}
