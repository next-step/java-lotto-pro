package lotto.domain;

import static lotto.constants.LottoConstants.LOTTO_TICKET_PRICE;
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
    void 나눗셈_테스트() {
        int result = Money.from(1000).divide(100);
        assertThat(result).isEqualTo(10);
    }

    @Test
    void 표가격보다_낮은지_체크() {
        assertThat(Money.from(900).isSmallerThan(LOTTO_TICKET_PRICE)).isTrue();
    }
}
