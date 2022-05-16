package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    void 나누기() {
        Money numerator = Money.from(10000);
        Money denominator = Money.from(1000);

        assertThat(numerator.divide(denominator)).isEqualTo(10);
    }

    @Test
    void 음수_예외() {
        assertThatThrownBy(() -> Money.from(-10)).isInstanceOf(
                IllegalArgumentException.class);
    }
}