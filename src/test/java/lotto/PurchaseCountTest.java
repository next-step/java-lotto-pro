package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class PurchaseCountTest {
    @Test
    void 생성() {
        assertThat(new PurchaseCount(5)).isEqualTo(new PurchaseCount(5));
    }

    @Test
    void 값_조회() {
        assertThat(new PurchaseCount(5).getPurchaseCount()).isEqualTo(5);
    }
}
