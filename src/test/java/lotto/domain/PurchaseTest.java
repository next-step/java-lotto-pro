package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseTest {

    @Test
    void 구입금액을_생성한다() {
        assertThat(new Purchase(1000)).isEqualTo(new Purchase(1000));
    }

    @Test
    void 구입금액은_음수가_될수없다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Purchase(-1000));
    }
}