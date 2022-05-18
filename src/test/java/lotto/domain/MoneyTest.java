package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoneyTest {

    private Money money1;
    private Money money2;

    @BeforeEach
    void setUp() {
        money1 = Money.from(10000);
        money2 = Money.from(1000);

    }

    @Test
    void 나누기() {
        assertThat(money1.divide(money2)).isEqualTo(BigDecimal.valueOf(10));
    }

    @Test
    void 더하기() {

        assertThat(money1.add(money2)).isEqualTo(Money.from(11000));
    }

    @Test
    void 음수_예외() {
        assertThatThrownBy(() -> Money.from(-10)).isInstanceOf(
                IllegalArgumentException.class);
    }
}