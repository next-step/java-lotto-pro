package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class QuantityTest {
    @Test
    void 생성() {
        assertThat(Quantity.from(5)).isEqualTo(Quantity.from(5));
    }

    @Test
    void 값_조회() {
        assertThat(Quantity.from(5).getQuantity()).isEqualTo(5);
    }
}
