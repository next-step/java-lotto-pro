package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PurchaseQuantityTest {
    @Test
    void 생성() {
        assertThat(new PurchaseQuantity(5)).isEqualTo(new PurchaseQuantity(5));
    }

    @Test
    void 값_조회() {
        assertThat(new PurchaseQuantity(5).getPurchaseQuantity()).isEqualTo(5);
    }
}
