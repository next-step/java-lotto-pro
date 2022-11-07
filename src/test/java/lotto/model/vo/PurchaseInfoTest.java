package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PurchaseInfoTest {

    @DisplayName("구매 개수 계산 확인")
    @Test
    void 로또_구매_개수() {
        long buyAmount = 14000;
        long expected = 14;
        assertThat(PurchaseInfo.calculatePurchaseCount(buyAmount)).isEqualTo(expected);
    }
}
