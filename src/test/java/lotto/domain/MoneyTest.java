package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 금액_유효성_체크() {
        assertThatThrownBy(
                () -> Money.from(-1000)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 돈에따_가능한_수량을_구할_수_있다() {
        int result = Money.from(1000).calculatePurchasableCount();
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 표가격보다_낮은지_체크() {
        assertThatThrownBy(
                () -> Money.from(900)
        ).isInstanceOf(IllegalArgumentException.class);
    }
}
